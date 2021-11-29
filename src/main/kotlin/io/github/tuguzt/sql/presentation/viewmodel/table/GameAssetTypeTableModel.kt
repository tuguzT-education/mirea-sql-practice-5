package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameAssetTypeEntity
import tornadofx.*

class GameAssetTypeTableModel : ViewModel() {
    val assetTypes = observableListOf(
        GameAssetTypeEntity("Hello", 0),
        GameAssetTypeEntity("World", 1),
    )
}
