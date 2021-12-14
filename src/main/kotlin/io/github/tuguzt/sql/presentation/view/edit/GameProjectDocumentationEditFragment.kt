package io.github.tuguzt.sql.presentation.view.edit

import io.github.tuguzt.sql.presentation.viewmodel.edit.GameProjectDocumentationEditModel
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectDocumentationModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectDocumentationTableModel
import io.github.tuguzt.sql.repository.model.GameProjectDocumentationEntity
import tornadofx.*

class GameProjectDocumentationEditFragment(override val itemModel: GameProjectDocumentationModel) :
    EntityEditFragment<GameProjectDocumentationEntity>(FX.messages["edit_game_project_documentation"]) {

    override val model: GameProjectDocumentationEditModel by inject()
    override val tableModel: GameProjectDocumentationTableModel by inject()

    override val root = scrollpane(fitToWidth = true, fitToHeight = true) {
        form {
            fieldset {
                field("#") {
                    label(itemModel.item.id.toString())
                }
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
