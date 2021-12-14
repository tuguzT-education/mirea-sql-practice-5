package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameAssetEntity

class GameAssetTableModel : EntityTableViewModel<GameAssetEntity>() {
    override val kClass = GameAssetEntity::class
    override val pathName = "game_assets"
}
