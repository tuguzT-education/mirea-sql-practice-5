package io.github.tuguzt.sql.presentation.view.edit

import io.github.tuguzt.sql.presentation.viewmodel.edit.GameProjectVersionEditModel
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectVersionModel
import tornadofx.*

class GameProjectVersionEditFragment(private val itemModel: GameProjectVersionModel) :
    Fragment(FX.messages["edit_game_project_version"]) {

    private val model: GameProjectVersionEditModel by inject()

    override val root = form {
        fieldset(messages["game_project_version_info"]) {
            field(messages["hash"]) {
                textfield(itemModel.hash).required()
            }
            field(messages["major"]) {
                textfield(itemModel.major).required()
            }
            field(messages["minor"]) {
                textfield(itemModel.minor).required()
            }
            field(messages["patch"]) {
                textfield(itemModel.patch).required()
            }
            field(messages["metadata"]) {
                textfield(itemModel.metadata)
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
