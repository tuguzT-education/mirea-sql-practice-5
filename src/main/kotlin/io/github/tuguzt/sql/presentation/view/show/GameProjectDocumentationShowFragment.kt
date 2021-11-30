package io.github.tuguzt.sql.presentation.view.show

import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectDocumentationModel
import tornadofx.*

class GameProjectDocumentationShowFragment(private val documentationModel: GameProjectDocumentationModel) :
    Fragment(FX.messages["game_project_documentation"]) {

    override val root = form {
        fieldset(messages["game_project_documentation_info"]) {
            field(messages["business_plan"]) {
                text(documentationModel.businessPlan)
            }
            field(messages["design_document"]) {
                text(documentationModel.designDocument)
            }
            field(messages["vision"]) {
                text(documentationModel.vision)
            }
        }
    }
}
