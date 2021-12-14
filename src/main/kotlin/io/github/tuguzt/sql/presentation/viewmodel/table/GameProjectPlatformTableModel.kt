package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameProjectPlatformEntity

class GameProjectPlatformTableModel : EntityTableModel<GameProjectPlatformEntity>(
    GameProjectPlatformEntity::class, "game_project_platforms",
)
