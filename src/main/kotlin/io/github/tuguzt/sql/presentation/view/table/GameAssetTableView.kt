package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.empty
import io.github.tuguzt.sql.presentation.view.edit.GameAssetEditFragment
import io.github.tuguzt.sql.presentation.view.show.GameAssetShowFragment
import io.github.tuguzt.sql.presentation.viewmodel.item.GameAssetModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameAssetTableModel
import io.github.tuguzt.sql.repository.model.GameAssetEntity
import javafx.scene.control.TableRow
import tornadofx.*

class GameAssetTableView : View(FX.messages["game_assets"]) {
    private val model: GameAssetTableModel by inject()
    private val itemModel = GameAssetModel(GameAssetEntity())

    override val root = tableview(model.assets) {
        isEditable = true
        setRowFactory {
            TableRow<GameAssetEntity?>().apply {
                fun editItem() {
                    openInternalWindow(GameAssetEditFragment(itemModel), movable = false, closeButton = false)
                }

                fun showItem() {
                    openInternalWindow(GameAssetShowFragment(itemModel), movable = false)
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

        column("#", GameAssetEntity::idProperty)
        column(messages["name"], GameAssetEntity::nameProperty)
        column(messages["description"], GameAssetEntity::descriptionProperty)
        column(messages["data"], GameAssetEntity::dataUriProperty)
        column<GameAssetEntity, String>(messages["type"], { it.value.typeProperty.select { it.nameProperty } })

        itemModel.rebindOnChange(this) { selected ->
            item = selected ?: GameAssetEntity()
        }
    }
}
