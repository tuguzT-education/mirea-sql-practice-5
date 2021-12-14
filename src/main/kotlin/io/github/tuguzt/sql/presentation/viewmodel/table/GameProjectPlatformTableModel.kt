package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameProjectPlatformEntity

class GameProjectPlatformTableModel : EntityTableViewModel<GameProjectPlatformEntity>() {
    override val kClass = GameProjectPlatformEntity::class
    override val pathName = "game_project_platforms"
}
