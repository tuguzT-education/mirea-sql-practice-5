package io.github.tuguzt.sql.presentation.view.show

import io.github.tuguzt.sql.presentation.viewmodel.item.GameAssetTypeModel
import tornadofx.*

class GameAssetTypeShowFragment(private val typeModel: GameAssetTypeModel) : Fragment(FX.messages["game_asset_type"]) {
    override val root = form {
        fieldset(messages["game_asset_type_info"]) {
            field(messages["name"]) {
                label(typeModel.name)
            }
        }
    }
}
