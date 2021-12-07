package io.github.tuguzt.sql.presentation.view.create

import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectDocumentationModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectDocumentationTableModel
import io.github.tuguzt.sql.repository.model.GameProjectDocumentationEntity
import tornadofx.*

class GameProjectDocumentationCreateFragment : Fragment(FX.messages["create_game_project_documentation"]) {
    private val tableModel: GameProjectDocumentationTableModel by inject()
    private val documentationModel = GameProjectDocumentationModel(GameProjectDocumentationEntity())

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
            buttonbar {
                button(messages["submit"]) {
                    enableWhen {
                        documentationModel.dirty and documentationModel.valid
                    }
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
            documentationModel.commit()
            tableModel.save(documentationModel.item)
        } ui {
            documentationModel.item = it
            close()
        }
    }
}
