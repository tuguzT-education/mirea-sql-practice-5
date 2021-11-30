package io.github.tuguzt.sql.presentation.view.edit

import io.github.tuguzt.sql.presentation.viewmodel.edit.GameProjectPlatformEditModel
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectPlatformModel
import tornadofx.*

class GameProjectPlatformEditFragment(private val platformModel: GameProjectPlatformModel) :
    Fragment(FX.messages["edit_game_project_platform"]) {

    private val model: GameProjectPlatformEditModel by inject()

    override val root = form {
        field(messages["name"]) {
            textfield(platformModel.name).required()
        }
        buttonbar {
            button(messages["submit"]) {
                enableWhen {
                    (platformModel.dirty and platformModel.valid) or (model.dirty and model.valid)
                }
                action(::submit)
            }
            button(messages["cancel"]) {
                action(::cancel)
            }
        }
    }

    private fun submit() {
        platformModel.commit()
        close()
    }

    private fun cancel() {
        platformModel.rollback()
        close()
    }
}
