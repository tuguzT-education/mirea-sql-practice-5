package io.github.tuguzt.sql.presentation.view.edit

import io.github.tuguzt.sql.presentation.viewmodel.edit.GameAssetTypeEditModel
import io.github.tuguzt.sql.presentation.viewmodel.item.GameAssetTypeModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameAssetTypeTableModel
import io.github.tuguzt.sql.repository.model.GameAssetTypeEntity
import tornadofx.*

class GameAssetTypeEditFragment(override val itemModel: GameAssetTypeModel) :
    EntityEditFragment<GameAssetTypeEntity>(FX.messages["edit_game_asset_type"]) {

    override val model: GameAssetTypeEditModel by inject()
    override val tableModel: GameAssetTypeTableModel by inject()

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
