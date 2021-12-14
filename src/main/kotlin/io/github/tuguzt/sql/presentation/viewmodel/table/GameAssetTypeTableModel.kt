package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameAssetTypeEntity

class GameAssetTypeTableModel : EntityTableModel<GameAssetTypeEntity>(
    GameAssetTypeEntity::class, "game_asset_types",
)
