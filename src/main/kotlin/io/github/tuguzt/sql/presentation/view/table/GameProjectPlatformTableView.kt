package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.empty
import io.github.tuguzt.sql.presentation.view.create.GameProjectPlatformCreateFragment
import io.github.tuguzt.sql.presentation.view.dialog.ConfirmDialog
import io.github.tuguzt.sql.presentation.view.dialog.OkDialog
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

    override val savable = booleanProperty()

    override val root = tableview(model.entities) {
        isEditable = true
        setRowFactory {
            TableRow<GameProjectPlatformEntity?>().apply {
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

        column("#", GameProjectPlatformEntity::idProperty)
        column(messages["name"], GameProjectPlatformEntity::nameProperty)

        itemModel.rebindOnChange(this) { selected ->
            item = selected ?: GameProjectPlatformEntity()
        }
    }

    fun onEdit() {
        val view = GameProjectPlatformEditFragment(itemModel)
        workspace.dock(view)
    }

    override fun onRefresh() {
        super.onRefresh()
        workspace.root.runAsyncWithOverlay(op = model::updateAll)
    }

    override fun onCreate() {
        super.onCreate()
        val view = GameProjectPlatformCreateFragment()
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
                val title = messages["delete_game_project_platform"]
                val text = messages["are_you_sure"]
                val confirmDialog = ConfirmDialog(title, text) { model.delete(item) }
                workspace.openInternalWindow(confirmDialog, movable = false, closeButton = false)
            }
        }
    }
}
