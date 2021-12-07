package io.github.tuguzt.sql.presentation.view.create

import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectDocumentationModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectDocumentationTableModel
import io.github.tuguzt.sql.repository.model.GameProjectDocumentationEntity
import tornadofx.*

class GameProjectDocumentationCreateFragment : Fragment(FX.messages["create_game_project_documentation"]) {
    private val tableModel: GameProjectDocumentationTableModel by inject()
    private val model = GameProjectDocumentationModel(GameProjectDocumentationEntity())

    override val root = form {
        fieldset {
            field(messages["business_plan"]) {
                textarea(model.businessPlan).required()
            }
            field(messages["design_document"]) {
                textarea(model.designDocument).required()
            }
            field(messages["vision"]) {
                textarea(model.vision).required()
            }
            buttonbar {
                button(messages["submit"]) {
                    enableWhen {
                        model.dirty and model.valid
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
            model.commit()
            tableModel.save(model.item)
        } ui {
            model.item = it
            close()
        }
    }
}
