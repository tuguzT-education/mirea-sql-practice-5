package io.github.tuguzt.sql.presentation.view.create

import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectPlatformModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectPlatformTableModel
import io.github.tuguzt.sql.repository.model.GameProjectPlatformEntity
import tornadofx.*

class GameProjectPlatformCreateFragment : View(FX.messages["create_game_project_platform"]) {
    private val tableModel: GameProjectPlatformTableModel by inject()
    private val model = GameProjectPlatformModel(GameProjectPlatformEntity())

    override val root = form {
        fieldset {
            field(messages["name"]) {
                textfield(model.name).required()
            }
            buttonbar {
                button(messages["submit"]) {
                    enableWhen { model.dirty and model.valid }
                    action(::submit)
                }
                button(messages["cancel"]) {
                    action(::close)
                }
            }
        }
    }

    private fun submit() {
        root.runAsyncWithOverlay {
            model.commit()
            tableModel.save(model.item)
        } ui {
            close()
        }
    }
}
