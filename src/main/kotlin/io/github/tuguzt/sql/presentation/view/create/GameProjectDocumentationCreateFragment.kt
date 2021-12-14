package io.github.tuguzt.sql.presentation.view.create

import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectDocumentationModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectDocumentationTableModel
import io.github.tuguzt.sql.repository.model.GameProjectDocumentationEntity
import tornadofx.*

class GameProjectDocumentationCreateFragment :
    EntityCreateFragment<GameProjectDocumentationEntity>(FX.messages["create_game_project_documentation"]) {

    override val tableModel: GameProjectDocumentationTableModel by inject()
    override val itemModel = GameProjectDocumentationModel(GameProjectDocumentationEntity())

    override val root = scrollpane(fitToWidth = true, fitToHeight = true) {
        form {
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
            }
        }
    }
}
