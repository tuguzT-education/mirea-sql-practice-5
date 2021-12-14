package io.github.tuguzt.sql.presentation.view.show

import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectPlatformModel
import tornadofx.*

class GameProjectPlatformShowFragment(private val itemModel: GameProjectPlatformModel) :
    Fragment(FX.messages["game_project_platform"]) {

    override val root = form {
        fieldset(messages["game_project_platform_info"]) {
            field(messages["name"]) {
                label(itemModel.name)
            }
        }
    }
}
