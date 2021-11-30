package io.github.tuguzt.sql.presentation.view.edit

import io.github.tuguzt.sql.presentation.viewmodel.edit.GameProjectDocumentationEditModel
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectDocumentationModel
import tornadofx.*

class GameProjectDocumentationEditFragment(private val documentationModel: GameProjectDocumentationModel) :
    Fragment(FX.messages["edit_game_project_documentation"]) {

    private val model: GameProjectDocumentationEditModel by inject()

    override val root = form {
        fieldset {
            field(messages["business_plan"]) {
                textarea(documentationModel.businessPlan).required()
            }
            field(messages["design_document"]) {
                textarea(documentationModel.designDocument).required()
            }
            field(messages["vision"]) {
                textarea(documentationModel.vision).required()
            }
        }
        buttonbar {
            button(messages["submit"]) {
                enableWhen {
                    (documentationModel.dirty and documentationModel.valid) or (model.dirty and model.valid)
                }
                action(::submit)
            }
            button(messages["cancel"]) {
                action(::cancel)
            }
        }
    }

    private fun submit() {
        documentationModel.commit()
        close()
    }

    private fun cancel() {
        documentationModel.rollback()
        close()
    }
}
