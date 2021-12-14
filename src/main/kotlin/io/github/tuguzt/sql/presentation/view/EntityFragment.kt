package io.github.tuguzt.sql.presentation.view

import io.github.tuguzt.sql.presentation.viewmodel.table.EntityTableViewModel
import tornadofx.*

abstract class EntityFragment<T : JsonModel>(title: String) : Fragment(title) {
    protected abstract val tableModel: EntityTableViewModel<T>
    protected abstract val itemModel: ItemViewModel<T>

    final override val deletable = booleanProperty()
    final override val creatable = booleanProperty()

    final override fun onRefresh() {
        super.onRefresh()
        itemModel.rollback()
    }

    final override fun onSave() {
        super.onSave()
        workspace.root.runAsyncWithOverlay {
            itemModel.commit()
            tableModel.save(itemModel.item)
        } ui {
            workspace.navigateBack()
            workspace.viewStack -= this
        }
    }
}
