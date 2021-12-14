package io.github.tuguzt.sql.presentation.view.show

import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectDocumentationModel
import tornadofx.*

class GameProjectDocumentationShowFragment(private val itemModel: GameProjectDocumentationModel) :
    Fragment(FX.messages["game_project_documentation"]) {

    override val root = form {
        fieldset(messages["game_project_documentation_info"]) {
            field(messages["business_plan"]) {
                text(itemModel.businessPlan)
            }
            field(messages["design_document"]) {
                text(itemModel.designDocument)
            }
            field(messages["vision"]) {
                text(itemModel.vision)
            }
        }
    }
}
