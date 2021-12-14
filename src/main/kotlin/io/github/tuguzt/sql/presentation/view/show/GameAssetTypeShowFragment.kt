package io.github.tuguzt.sql.presentation.view.show

import io.github.tuguzt.sql.presentation.viewmodel.item.GameAssetTypeModel
import tornadofx.*

class GameAssetTypeShowFragment(private val itemModel: GameAssetTypeModel) : Fragment(FX.messages["game_asset_type"]) {
    override val root = form {
        fieldset(messages["game_asset_type_info"]) {
            field(messages["name"]) {
                label(itemModel.name)
            }
        }
    }
}
