package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.empty
import io.github.tuguzt.sql.presentation.view.create.GameAssetTypeCreateFragment
import io.github.tuguzt.sql.presentation.view.dialog.ConfirmDialog
import io.github.tuguzt.sql.presentation.view.dialog.OkDialog
import io.github.tuguzt.sql.presentation.view.edit.GameAssetTypeEditFragment
import io.github.tuguzt.sql.presentation.viewmodel.item.GameAssetTypeModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameAssetTypeTableModel
import io.github.tuguzt.sql.repository.model.GameAssetTypeEntity
import javafx.beans.binding.BooleanExpression
import javafx.beans.property.SimpleBooleanProperty
import javafx.scene.control.TableRow
import tornadofx.*

class GameAssetTypeTableView : View(FX.messages["game_asset_types"]) {
    private val model: GameAssetTypeTableModel by inject()
    private val itemModel = GameAssetTypeModel(GameAssetTypeEntity())

    override val savable = booleanProperty()

    override val root = tableview(model.entities) {
        isEditable = true
        setRowFactory {
            TableRow<GameAssetTypeEntity?>().apply {
                onDoubleClick {
                    if (isEmpty) return@onDoubleClick
                    onEdit()
                }
                contextmenu {
                    disableWhen(empty)
                    item(messages["edit"]).action(::onEdit)
                    item(messages["remove"]).action(::onDelete)
                }
            }
        }

        column("#", GameAssetTypeEntity::idProperty)
        column(messages["name"], GameAssetTypeEntity::nameProperty)

        itemModel.rebindOnChange(this) { selected ->
            item = selected ?: GameAssetTypeEntity()
        }
    }

    private fun onEdit() {
        val view = GameAssetTypeEditFragment(itemModel)
        workspace.dock(view)
    }

    override fun onRefresh() {
        super.onRefresh()
        workspace.root.runAsyncWithOverlay(op = model::updateAll)
    }

    override fun onCreate() {
        super.onCreate()
        val view = GameAssetTypeCreateFragment()
        workspace.dock(view)
    }

    override fun onDelete() {
        super.onDelete()
        when (val item = root.selectedItem) {
            null -> {
                val dialog = OkDialog(messages["item_not_selected"])
                workspace.openInternalWindow(dialog, movable = false, closeButton = false)
            }
            else -> {
                val title = messages["delete_game_asset_type"]
                val text = messages["are_you_sure"]
                val dialog = ConfirmDialog(title, text) { model.delete(item) }
                workspace.openInternalWindow(dialog, movable = false, closeButton = false)
            }
        }
    }
}
