package io.github.tuguzt.sql.presentation.view.edit

import io.github.tuguzt.sql.presentation.viewmodel.edit.GameProjectEditModel
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectDocumentationTableModel
import tornadofx.*

class GameProjectEditFragment(private val projectModel: GameProjectModel) : Fragment(FX.messages["edit_game_project"]) {
    private val model: GameProjectEditModel by inject()
    private val documentationTableModel: GameProjectDocumentationTableModel by inject()

    override val root = form {
        fieldset {
            field(messages["name"]) {
                textfield(projectModel.name)
            }
            field(messages["description"]) {
                textarea(projectModel.description)
            }
            field(messages["documentation"]) {
                combobox(projectModel.documentation, values = documentationTableModel.entities)
            }
            buttonbar {
                button(messages["submit"]) {
                    enableWhen {
                        (projectModel.dirty and projectModel.valid) or (model.dirty and model.valid)
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
        projectModel.commit()
        close()
    }

    private fun cancel() {
        projectModel.rollback()
        close()
    }
}
