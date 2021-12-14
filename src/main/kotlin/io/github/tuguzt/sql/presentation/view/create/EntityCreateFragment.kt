package io.github.tuguzt.sql.presentation.view.create

import io.github.tuguzt.sql.presentation.view.EntityFragment
import tornadofx.*

sealed class EntityCreateFragment<T : JsonModel>(title: String) : EntityFragment<T>(title) {
    final override val refreshable by lazy { itemModel.dirty }
    final override val savable by lazy { itemModel.dirty and itemModel.valid }
}
