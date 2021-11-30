package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameProjectVersionEntity
import tornadofx.*

class GameProjectVersionTableModel : ViewModel() {
    private val api: Rest by inject()

    val versions = api.get("game_project_versions/all").list().toModel<GameProjectVersionEntity>()
}
