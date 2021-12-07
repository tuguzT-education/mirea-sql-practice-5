package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.empty
import io.github.tuguzt.sql.presentation.view.create.GameAssetTypeCreateFragment
import io.github.tuguzt.sql.presentation.view.dialog.ConfirmDialog
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

    override val root = borderpane {
        top = hbox(spacing = 8) {
            button(messages["refresh"]).action(::refresh)
            button(messages["add"]).action {
                openInternalWindow(GameAssetTypeCreateFragment(), movable = false, closeButton = false)
            }
        }
        center = tableview(model.entities) {
            isEditable = true
            setRowFactory {
                TableRow<GameAssetTypeEntity?>().apply {
                    fun editItem() {
                        openInternalWindow(GameAssetTypeEditFragment(itemModel), movable = false, closeButton = false)
                    }

                    fun showItem() {
                        openInternalWindow(GameAssetTypeShowFragment(itemModel), movable = false)
                    }

                    fun removeItem() {
                        val title = messages["delete_game_asset_type"]
                        val text = messages["are_you_sure"]
                        val confirmDialog = ConfirmDialog(title, text) { model.delete(item!!) }
                        openInternalWindow(confirmDialog, movable = false, closeButton = false)
                    }

                    onDoubleClick {
                        if (isEmpty) return@onDoubleClick
                        showItem()
                    }
                    contextmenu {
                        disableWhen(empty)
                        item(messages["show"]).action(::showItem)
                        item(messages["edit"]).action(::editItem)
                        item(messages["remove"]).action(::removeItem)
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

    init {
        runAsync { model.updateAll() }
    }

    private fun refresh() {
        root.runAsyncWithOverlay(op = model::updateAll)
    }
}
