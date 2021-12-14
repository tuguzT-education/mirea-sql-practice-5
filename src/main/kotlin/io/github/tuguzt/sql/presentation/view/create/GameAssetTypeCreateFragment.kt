package io.github.tuguzt.sql.presentation.view.create

import io.github.tuguzt.sql.presentation.viewmodel.item.GameAssetTypeModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameAssetTypeTableModel
import io.github.tuguzt.sql.repository.model.GameAssetTypeEntity
import tornadofx.*

class GameAssetTypeCreateFragment : EntityCreateFragment<GameAssetTypeEntity>(FX.messages["create_game_asset_type"]) {
    override val tableModel: GameAssetTypeTableModel by inject()
    override val itemModel = GameAssetTypeModel(GameAssetTypeEntity())

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
