package io.github.tuguzt.sql.presentation.view

import io.github.tuguzt.sql.presentation.view.converter.FileStringConverter
import io.github.tuguzt.sql.presentation.viewmodel.GameAssetEditModel
import io.github.tuguzt.sql.presentation.viewmodel.GameAssetModel
import javafx.stage.FileChooser.ExtensionFilter
import tornadofx.*
import java.io.File
import java.net.URI

class GameAssetEditFragment(private val gameAssetModel: GameAssetModel) : Fragment(FX.messages["edit_game_asset"]) {
    private val model: GameAssetEditModel by inject()

    init {
        val string = requireNotNull(gameAssetModel.dataUri.value)
        val uri = URI(string)
        model.selectedFile = File(uri)
    }

    override val root = form {
        fieldset {
            field(messages["name"]) {
                textfield(gameAssetModel.name).required()
            }
            field(messages["description"]) {
                textarea(gameAssetModel.description).required()
            }
            field(messages["data"]) {
                hyperlink(messages["choose_file"]) {
                    action(::chooseFile)
                    model.addValidator(this, model.selectedFileProperty) {
                        if (it == null) error(messages["file_must_be_chosen"]) else null
                    }
                    gameAssetModel.addValidator(this, gameAssetModel.dataUri) {
                        if (it == null) error(messages["file_must_be_chosen"]) else null
                    }
                }
                label(model.selectedFileProperty, converter = FileStringConverter())
                button(messages["clear"]) {
                    enableWhen(model::valid)
                    action {
                        gameAssetModel.dataUri.value = null
                        model.selectedFile = null
                    }
                }
            }
            field(messages["type"]) {
                combobox(gameAssetModel.type) {
                    // TODO
                }
            }
            buttonbar {
                button(messages["submit"]) {
                    enableWhen {
                        (gameAssetModel.dirty and gameAssetModel.valid) or (model.dirty and model.valid)
                    }
                    action(::submit)
                }
                button(messages["cancel"]) {
                    action(::cancel)
                }
            }
        }
    }

    private fun chooseFile() {
        val file = chooseFile(
            title = messages["choose_asset_file"],
            filters = arrayOf(ExtensionFilter(messages["text"], ".txt")),
            mode = FileChooserMode.Single,
        ).firstOrNull()
        file?.let {
            gameAssetModel.dataUri.value = it.toURI().toString()
            model.selectedFile = it
        }
    }

    private fun submit() {
        gameAssetModel.commit()
        close()
    }

    private fun cancel() {
        gameAssetModel.rollback()
        close()
    }
}
