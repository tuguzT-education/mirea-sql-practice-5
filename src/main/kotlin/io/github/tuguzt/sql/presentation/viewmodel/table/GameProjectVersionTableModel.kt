package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameProjectVersionEntity

class GameProjectVersionTableModel : EntityTableViewModel<GameProjectVersionEntity>() {
    override val kClass = GameProjectVersionEntity::class
    override val pathName = "game_project_versions"
}
