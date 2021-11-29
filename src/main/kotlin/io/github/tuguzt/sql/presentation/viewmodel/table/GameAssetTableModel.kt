package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameAssetEntity
import io.github.tuguzt.sql.repository.model.GameAssetTypeEntity
import tornadofx.*

class GameAssetTableModel : ViewModel() {
    val assets = observableListOf(
        GameAssetEntity("Hello", "Some shit", "file:///file.txt", GameAssetTypeEntity("World", 1)),
    )
}
