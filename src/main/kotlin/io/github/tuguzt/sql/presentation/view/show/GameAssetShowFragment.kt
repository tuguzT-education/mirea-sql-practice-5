package io.github.tuguzt.sql.presentation.view.show

import io.github.tuguzt.sql.presentation.viewmodel.item.GameAssetModel
import tornadofx.*

class GameAssetShowFragment(private val assetModel: GameAssetModel) : Fragment(FX.messages["game_asset"]) {
    override val root = form {
        fieldset(messages["game_asset_info"]) {
            field(messages["name"]) {
                label(assetModel.name)
            }
            field(messages["description"]) {
                text(assetModel.description)
            }
            field(messages["data"]) {
                label(assetModel.dataUri)
                button(messages["open_file"])
            }
            field(messages["type"]) {
                label(assetModel.type.select { it.nameProperty })
            }
        }
    }
}
