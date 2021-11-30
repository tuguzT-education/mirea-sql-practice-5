package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameProjectEntity
import tornadofx.*

class GameProjectTableModel : ViewModel() {
    private val api: Rest by inject()

    val gameProjects = api.get("game_projects/all").list().toModel<GameProjectEntity>()
}
