package io.github.tuguzt.sql.presentation.view.show

import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectModel
import tornadofx.*

class GameProjectShowFragment(private val projectModel: GameProjectModel) : Fragment(FX.messages["game_project"]) {
    override val root = form {
        fieldset(messages["game_project_info"]) {
            field(messages["name"]) {
                label(projectModel.name)
            }
            field(messages["description"]) {
                text(projectModel.description)
            }
            field(messages["documentation"]) {
                hyperlink(projectModel.documentation.toString()) {
                    action { TODO() }
                }
            }
        }
    }
}
