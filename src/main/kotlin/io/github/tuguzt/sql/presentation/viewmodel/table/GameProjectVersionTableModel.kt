package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameProjectVersionEntity

class GameProjectVersionTableModel : EntityTableViewModel<GameProjectVersionEntity>() {
    override val kClass = GameProjectVersionEntity::class
    override val pathName = "game_project_versions"

    private val gameProjectTableModel: GameProjectTableModel by inject()

    override fun handleResult(result: List<GameProjectVersionEntity>) {
        gameProjectTableModel.updateAll()
        result.forEach { version ->
            val gameProject = gameProjectTableModel.entities.find { version in it.versions }
            gameProject?.let { version.gameProject = it }
        }
    }
}
