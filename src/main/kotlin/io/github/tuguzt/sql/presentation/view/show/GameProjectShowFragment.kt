package io.github.tuguzt.sql.presentation.view.show

import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectModel
import tornadofx.*

class GameProjectShowFragment(private val itemModel: GameProjectModel) : Fragment(FX.messages["game_project"]) {
    override val root = form {
        fieldset(messages["game_project_info"]) {
            field(messages["name"]) {
                label(itemModel.name)
            }
            field(messages["description"]) {
                text(itemModel.description)
            }
            field(messages["documentation"]) {
                hyperlink(itemModel.documentation.toString()) {
                    action { TODO() }
                }
            }
        }
    }
}
