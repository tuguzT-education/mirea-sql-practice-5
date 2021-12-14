package io.github.tuguzt.sql.presentation.view.create

import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectPlatformModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectPlatformTableModel
import io.github.tuguzt.sql.repository.model.GameProjectPlatformEntity
import tornadofx.*

class GameProjectPlatformCreateFragment : EntityCreateFragment<GameProjectPlatformEntity>(
    FX.messages["create_game_project_platform"],
) {
    override val tableModel: GameProjectPlatformTableModel by inject()
    override val itemModel = GameProjectPlatformModel(GameProjectPlatformEntity())

    override val root = scrollpane(fitToWidth = true, fitToHeight = true) {
        form {
            fieldset {
                field(messages["name"]) {
                    textfield(itemModel.name).required()
                }
            }
        }
    }
}
