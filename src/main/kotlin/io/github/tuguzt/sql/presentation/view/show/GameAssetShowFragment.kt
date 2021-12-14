package io.github.tuguzt.sql.presentation.view.show

import io.github.tuguzt.sql.presentation.viewmodel.item.GameAssetModel
import tornadofx.*

class GameAssetShowFragment(private val itemModel: GameAssetModel) : Fragment(FX.messages["game_asset"]) {
    override val root = form {
        fieldset(messages["game_asset_info"]) {
            field(messages["name"]) {
                label(itemModel.name)
            }
            field(messages["description"]) {
                text(itemModel.description)
            }
            field(messages["data"]) {
                label(itemModel.dataUri)
                button(messages["open_file"])
            }
            field(messages["type"]) {
                label(itemModel.type.select { it.nameProperty })
            }
        }
    }
}
