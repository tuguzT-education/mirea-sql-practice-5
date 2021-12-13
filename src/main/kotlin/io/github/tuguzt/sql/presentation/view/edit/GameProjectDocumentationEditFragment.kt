package io.github.tuguzt.sql.presentation.view.edit

import io.github.tuguzt.sql.presentation.viewmodel.edit.GameProjectDocumentationEditModel
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectDocumentationModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectDocumentationTableModel
import tornadofx.*

class GameProjectDocumentationEditFragment(private val itemModel: GameProjectDocumentationModel) :
    Fragment(FX.messages["edit_game_project_documentation"]) {

    private val model: GameProjectDocumentationEditModel by inject()
    private val tableModel: GameProjectDocumentationTableModel by inject()

    override val root = form {
        fieldset {
            field(messages["business_plan"]) {
                textarea(itemModel.businessPlan).required()
            }
            field(messages["design_document"]) {
                textarea(itemModel.designDocument).required()
            }
            field(messages["vision"]) {
                textarea(itemModel.vision).required()
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
        root.runAsyncWithOverlay {
            itemModel.commit()
            tableModel.save(itemModel.item)
        } ui {
            close()
        }
    }

    private fun cancel() {
        itemModel.rollback()
        close()
    }
}
