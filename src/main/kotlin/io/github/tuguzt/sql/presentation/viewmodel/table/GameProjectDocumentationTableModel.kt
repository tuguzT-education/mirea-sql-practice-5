package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameProjectDocumentationEntity

class GameProjectDocumentationTableModel : EntityTableViewModel<GameProjectDocumentationEntity>() {
    override val kClass = GameProjectDocumentationEntity::class
    override val pathName = "game_project_documentations"
}
