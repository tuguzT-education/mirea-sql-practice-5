package io.github.tuguzt.sql.presentation.view.show

import io.github.tuguzt.sql.presentation.view.converter.GameProjectStringConverter
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectVersionModel
import tornadofx.*

class GameProjectVersionShowFragment(private val itemModel: GameProjectVersionModel) :
    Fragment(FX.messages["game_project_version"]) {

    override val root = form {
        fieldset(messages["game_project_version_info"]) {
            field(messages["hash"]) {
                label(itemModel.hash)
            }
            field(messages["major"]) {
                label(itemModel.major)
            }
            field(messages["minor"]) {
                label(itemModel.minor)
            }
            field(messages["patch"]) {
                label(itemModel.patch)
            }
            field(messages["metadata"]) {
                label(itemModel.metadata)
            }
            field(messages["game_project"]) {
                label(itemModel.gameProject, converter = GameProjectStringConverter)
            }
        }
    }
}
