package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameAssetEntity
import tornadofx.*

class GameAssetTableModel : ViewModel() {
    private val api: Rest by inject()

    val assets = api.get("game_assets/all").list().toModel<GameAssetEntity>()
}
