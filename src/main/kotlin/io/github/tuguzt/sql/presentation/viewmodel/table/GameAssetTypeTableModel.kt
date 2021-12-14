package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameAssetTypeEntity

class GameAssetTypeTableModel : EntityTableViewModel<GameAssetTypeEntity>() {
    override val kClass = GameAssetTypeEntity::class
    override val pathName = "game_asset_types"
}
