package io.github.tuguzt.sql.presentation.view.edit

import io.github.tuguzt.sql.presentation.view.converter.FileStringConverter
import io.github.tuguzt.sql.presentation.view.converter.GameAssetTypeStringConverter
import io.github.tuguzt.sql.presentation.viewmodel.edit.GameAssetEditModel
import io.github.tuguzt.sql.presentation.viewmodel.item.GameAssetModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameAssetTypeTableModel
import javafx.stage.FileChooser.ExtensionFilter
import tornadofx.*
import java.io.File
import java.net.URI

class GameAssetEditFragment(private val itemModel: GameAssetModel) : Fragment(FX.messages["edit_game_asset"]) {
    private val model: GameAssetEditModel by inject()
    private val assetTypeTableModel: GameAssetTypeTableModel by inject()

    init {
        val string = requireNotNull(itemModel.dataUri.value)
        val uri = URI(string)
        model.selectedFile = File(uri)
    }

    override val root = form {
        fieldset {
            field(messages["name"]) {
                textfield(itemModel.name).required()
            }
            field(messages["description"]) {
                textarea(itemModel.description).required()
            }
            field(messages["data"]) {
                hyperlink(messages["choose_file"]) {
                    action(::chooseFile)
                    model.addValidator(this, model.selectedFileProperty) {
                        if (it == null) error(messages["file_must_be_chosen"]) else null
                    }
                    itemModel.addValidator(this, itemModel.dataUri) {
                        if (it == null) error(messages["file_must_be_chosen"]) else null
                    }
                }
                label(model.selectedFileProperty, converter = FileStringConverter)
                button(messages["clear"]) {
                    enableWhen(model::valid)
                    action {
                        itemModel.dataUri.value = null
                        model.selectedFile = null
                    }
                }
            }
            field(messages["type"]) {
                combobox(itemModel.type, values = assetTypeTableModel.entities) {
                    converter = GameAssetTypeStringConverter
                }
            }
        }
        buttonbar {
            button(messages["submit"]) {
                enableWhen {
                    (itemModel.dirty and itemModel.valid) or (model.dirty and model.valid)
                }
                action(::submit)
            }
            button(messages["cancel"]) {
                action(::cancel)
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
            itemModel.dataUri.value = it.toURI().toString()
            model.selectedFile = it
        }
    }

    private fun submit() {
        itemModel.commit()
        close()
    }

    private fun cancel() {
        itemModel.rollback()
        close()
    }
}
