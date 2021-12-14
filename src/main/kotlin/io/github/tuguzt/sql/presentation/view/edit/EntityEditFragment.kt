package io.github.tuguzt.sql.presentation.view.edit

import io.github.tuguzt.sql.presentation.view.EntityFragment
import tornadofx.*

sealed class EntityEditFragment<T : JsonModel>(title: String) : EntityFragment<T>(title) {
    protected abstract val model: ViewModel

    final override val refreshable by lazy { itemModel.dirty or model.dirty }
    final override val savable by lazy { (itemModel.dirty and itemModel.valid) or (model.dirty and model.valid) }
}
