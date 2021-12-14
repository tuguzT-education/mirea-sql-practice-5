package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameProjectEntity

class GameProjectTableModel : EntityTableViewModel<GameProjectEntity>() {
    override val kClass = GameProjectEntity::class
    override val pathName = "game_projects"
}
