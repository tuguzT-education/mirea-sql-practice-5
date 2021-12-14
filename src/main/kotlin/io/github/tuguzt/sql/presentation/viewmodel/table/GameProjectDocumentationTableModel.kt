package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameProjectDocumentationEntity

class GameProjectDocumentationTableModel : EntityTableModel<GameProjectDocumentationEntity>(
    GameProjectDocumentationEntity::class, "game_project_documentations",
)
