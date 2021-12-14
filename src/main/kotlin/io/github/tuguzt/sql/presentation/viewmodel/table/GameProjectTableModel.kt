package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameProjectEntity

class GameProjectTableModel : EntityTableModel<GameProjectEntity>(GameProjectEntity::class, "game_projects")
