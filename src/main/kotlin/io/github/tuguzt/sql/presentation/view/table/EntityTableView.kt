package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.view.create.EntityCreateFragment
import io.github.tuguzt.sql.presentation.view.dialog.ConfirmDialog
import io.github.tuguzt.sql.presentation.view.dialog.OkDialog
import io.github.tuguzt.sql.presentation.view.edit.EntityEditFragment
import io.github.tuguzt.sql.presentation.viewmodel.table.EntityTableViewModel
import javafx.scene.control.TableView
import tornadofx.*

sealed class EntityTableView<T : JsonModel>(title: String) : View(title) {
    protected abstract val model: EntityTableViewModel<T>
    protected abstract val itemModel: ItemViewModel<T>

    protected abstract val createFragmentFactory: () -> EntityCreateFragment<T>
    protected abstract val editFragmentFactory: () -> EntityEditFragment<T>

    final override val savable = booleanProperty()

    abstract override val root: TableView<T>

    final fun onEdit() {
        workspace.dock(editFragmentFactory.invoke())
    }

    final override fun onRefresh() {
        super.onRefresh()
        workspace.root.runAsyncWithOverlay(op = model::updateAll)
    }

    final override fun onCreate() {
        super.onCreate()
        workspace.dock(createFragmentFactory.invoke())
    }

    final override fun onDelete() {
        super.onDelete()
        when (val item = root.selectedItem) {
            null -> {
                val dialog = OkDialog(messages["item_not_selected"])
                workspace.openInternalWindow(dialog, movable = false, closeButton = false)
            }
            else -> {
                val title = messages["delete_element"]
                val text = messages["are_you_sure"]
                val confirmDialog = ConfirmDialog(title, text) { model.delete(item) }
                workspace.openInternalWindow(confirmDialog, movable = false, closeButton = false)
            }
        }
    }
}
