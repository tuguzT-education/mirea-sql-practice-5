package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.empty
import io.github.tuguzt.sql.presentation.view.edit.GameAssetTypeEditFragment
import io.github.tuguzt.sql.presentation.view.show.GameAssetTypeShowFragment
import io.github.tuguzt.sql.presentation.viewmodel.item.GameAssetTypeModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameAssetTypeTableModel
import io.github.tuguzt.sql.repository.model.GameAssetTypeEntity
import javafx.scene.control.TableRow
import tornadofx.*

class GameAssetTypeTableView : View(FX.messages["game_asset_types"]) {
    private val model: GameAssetTypeTableModel by inject()
    private val itemModel = GameAssetTypeModel(GameAssetTypeEntity())

    override val root = tableview(model.assetTypes) {
        isEditable = true
        setRowFactory {
            TableRow<GameAssetTypeEntity?>().apply {
                fun editItem() {
                    openInternalWindow(GameAssetTypeEditFragment(itemModel), movable = false, closeButton = false)
                }

                fun showItem() {
                    openInternalWindow(GameAssetTypeShowFragment(itemModel), movable = false)
                }

                onDoubleClick {
                    if (isEmpty) return@onDoubleClick
                    showItem()
                }
                contextmenu {
                    disableWhen(empty)
                    item(messages["show"]).action(::showItem)
                    item(messages["edit"]).action(::editItem)
                }
            }
        }

        column("#", GameAssetTypeEntity::idProperty)
        column(messages["name"], GameAssetTypeEntity::nameProperty)

        itemModel.rebindOnChange(this) { selected ->
            item = selected ?: GameAssetTypeEntity()
        }
    }
}
