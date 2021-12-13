package io.github.tuguzt.sql.presentation.view.edit

import io.github.tuguzt.sql.presentation.viewmodel.edit.GameProjectEditModel
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectDocumentationTableModel
import tornadofx.*

class GameProjectEditFragment(private val itemModel: GameProjectModel) : Fragment(FX.messages["edit_game_project"]) {
    private val model: GameProjectEditModel by inject()
    private val documentationTableModel: GameProjectDocumentationTableModel by inject()

    override val root = form {
        fieldset {
            field(messages["name"]) {
                textfield(itemModel.name)
            }
            field(messages["description"]) {
                textarea(itemModel.description)
            }
            field(messages["documentation"]) {
                combobox(itemModel.documentation, values = documentationTableModel.entities)
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
