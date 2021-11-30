package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameProjectDocumentationEntity
import tornadofx.*

class GameProjectDocumentationTableModel : ViewModel() {
    private val api: Rest by inject()

    val documentations = api.get("game_project_documentations/all").list().toModel<GameProjectDocumentationEntity>()
}
