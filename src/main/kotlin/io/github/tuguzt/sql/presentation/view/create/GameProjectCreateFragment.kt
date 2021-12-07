package io.github.tuguzt.sql.presentation.view.create

import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectDocumentationTableModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectTableModel
import io.github.tuguzt.sql.repository.model.GameProjectEntity
import tornadofx.*

class GameProjectCreateFragment : Fragment(FX.messages["create_game_project"]) {
    private val tableModel: GameProjectTableModel by inject()
    private val documentationTableModel: GameProjectDocumentationTableModel by inject()
    private val model = GameProjectModel(GameProjectEntity())

    override val root = form {
        fieldset {
            field(messages["name"]) {
                textfield(model.name)
            }
            field(messages["description"]) {
                textarea(model.description)
            }
            field(messages["documentation"]) {
                combobox(model.documentation, values = documentationTableModel.entities)
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
            model.item = it
            close()
        }
    }
}
