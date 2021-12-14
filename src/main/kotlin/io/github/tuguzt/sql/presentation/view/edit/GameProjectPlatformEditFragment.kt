package io.github.tuguzt.sql.presentation.view.edit

import io.github.tuguzt.sql.presentation.viewmodel.edit.GameProjectPlatformEditModel
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectPlatformModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectPlatformTableModel
import io.github.tuguzt.sql.repository.model.GameProjectPlatformEntity
import tornadofx.*

class GameProjectPlatformEditFragment(override val itemModel: GameProjectPlatformModel) :
    EntityEditFragment<GameProjectPlatformEntity>(FX.messages["edit_game_project_platform"]) {

    override val model: GameProjectPlatformEditModel by inject()
    override val tableModel: GameProjectPlatformTableModel by inject()

    override val root = scrollpane(fitToWidth = true, fitToHeight = true) {
        form {
            fieldset {
                field("#") {
                    label(itemModel.item.id.toString())
                }
                field(messages["name"]) {
                    textfield(itemModel.name).required()
                }
            }
        }
    }
}
