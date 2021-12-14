package io.github.tuguzt.sql.presentation.view.create

import io.github.tuguzt.sql.presentation.viewmodel.table.EntityTableViewModel
import tornadofx.*

sealed class EntityCreateFragment<T : JsonModel>(title: String) : Fragment(title) {
    protected abstract val tableModel: EntityTableViewModel<T>
    protected abstract val itemModel: ItemViewModel<T>

    final override val refreshable by lazy { itemModel.dirty }
    final override val savable by lazy { itemModel.dirty and itemModel.valid }
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
