package io.github.tuguzt.sql.presentation.view.show

import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectVersionModel
import tornadofx.*

class GameProjectVersionShowFragment(private val versionModel: GameProjectVersionModel) :
    Fragment(FX.messages["game_project_version"]) {

    override val root = form {
        fieldset(messages["game_project_version_info"]) {
            field(messages["hash"]) {
                label(versionModel.hash)
            }
            field(messages["major"]) {
                label(versionModel.major)
            }
            field(messages["minor"]) {
                label(versionModel.minor)
            }
            field(messages["patch"]) {
                label(versionModel.patch)
            }
            field(messages["metadata"]) {
                label(versionModel.metadata)
            }
        }
    }
}
