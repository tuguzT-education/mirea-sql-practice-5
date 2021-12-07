package io.github.tuguzt.sql.presentation.view.edit

import io.github.tuguzt.sql.presentation.viewmodel.edit.GameProjectVersionEditModel
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectVersionModel
import tornadofx.*

class GameProjectVersionEditFragment(private val versionModel: GameProjectVersionModel) :
    Fragment(FX.messages["edit_game_project_version"]) {

    private val model: GameProjectVersionEditModel by inject()

    override val root = form {
        fieldset(messages["game_project_version_info"]) {
            field(messages["hash"]) {
                textfield(versionModel.hash).required()
            }
            field(messages["major"]) {
                textfield(versionModel.major).required()
            }
            field(messages["minor"]) {
                textfield(versionModel.minor).required()
            }
            field(messages["patch"]) {
                textfield(versionModel.patch).required()
            }
            field(messages["metadata"]) {
                textfield(versionModel.metadata)
            }
            buttonbar {
                button(messages["submit"]) {
                    enableWhen {
                        (versionModel.dirty and versionModel.valid) or (model.dirty and model.valid)
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
        versionModel.commit()
        close()
    }

    private fun cancel() {
        versionModel.rollback()
        close()
    }
}
