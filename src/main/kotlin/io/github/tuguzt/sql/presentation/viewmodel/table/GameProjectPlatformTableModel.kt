package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameProjectPlatformEntity
import tornadofx.*

class GameProjectPlatformTableModel : ViewModel() {
    private val api: Rest by inject()

    val platforms = api.get("game_project_platforms/all").list().toModel<GameProjectPlatformEntity>()
}
