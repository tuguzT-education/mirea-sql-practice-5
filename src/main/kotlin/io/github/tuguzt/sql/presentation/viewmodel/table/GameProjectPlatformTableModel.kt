package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameProjectPlatformEntity
import tornadofx.*

class GameProjectPlatformTableModel : ViewModel() {
    private val api: Rest by inject()

    val entities = observableListOf<GameProjectPlatformEntity>()

    fun updateAll() {
        entities.clear()
        entities += api.get("game_project_platforms/all").list().toModel()
    }

    fun save(entity: GameProjectPlatformEntity): GameProjectPlatformEntity {
        val result = api.post("game_project_platforms/save", entity).one().toModel<GameProjectPlatformEntity>()
        if (result !in entities) entities += result
        return result
    }

    fun delete(entity: GameProjectPlatformEntity) {
        api.delete("game_project_platforms/delete", entity)
        entities -= entity
    }
}
