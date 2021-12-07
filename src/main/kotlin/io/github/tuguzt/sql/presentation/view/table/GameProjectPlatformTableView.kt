package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.empty
import io.github.tuguzt.sql.presentation.view.create.GameProjectPlatformCreateFragment
import io.github.tuguzt.sql.presentation.view.dialog.ConfirmDialog
import io.github.tuguzt.sql.presentation.view.edit.GameProjectPlatformEditFragment
import io.github.tuguzt.sql.presentation.view.show.GameProjectPlatformShowFragment
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectPlatformModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectPlatformTableModel
import io.github.tuguzt.sql.repository.model.GameProjectPlatformEntity
import javafx.scene.control.TableRow
import tornadofx.*

class GameProjectPlatformTableView : View(FX.messages["game_project_platforms"]) {
    private val model: GameProjectPlatformTableModel by inject()
    private val itemModel = GameProjectPlatformModel(GameProjectPlatformEntity())

    override val root = borderpane {
        top = hbox(spacing = 8) {
            button(messages["refresh"]).action(::refresh)
            button(messages["add"]).action {
                openInternalWindow(GameProjectPlatformCreateFragment(), movable = false, closeButton = false)
            }
        }
        center = tableview(model.entities) {
            isEditable = true
            setRowFactory {
                TableRow<GameProjectPlatformEntity?>().apply {
                    fun editItem() {
                        openInternalWindow(GameProjectPlatformEditFragment(itemModel), movable = false, closeButton = false)
                    }

                    fun showItem() {
                        openInternalWindow(GameProjectPlatformShowFragment(itemModel), movable = false)
                    }

                    fun removeItem() {
                        val title = messages["delete_game_project_platform"]
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
                    }
                }
            }

            column("#", GameProjectPlatformEntity::idProperty)
            column(messages["name"], GameProjectPlatformEntity::nameProperty)

            itemModel.rebindOnChange(this) { selected ->
                item = selected ?: GameProjectPlatformEntity()
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
