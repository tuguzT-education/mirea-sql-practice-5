package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameProjectPlatformEntity
import tornadofx.*

class GameProjectPlatformTableModel : ViewModel() {
    private val api: Rest by inject()

    val entities = observableListOf<GameProjectPlatformEntity>()

    fun updateAll() {
        val result = api.get("game_project_platforms/all").list().toModel<GameProjectPlatformEntity>()
        entities.setAll(result)
    }

    fun save(entity: GameProjectPlatformEntity): GameProjectPlatformEntity {
        val result = api.post("game_project_platforms/save", entity).one().toModel<GameProjectPlatformEntity>()
        when (result) {
            in entities -> {
                val index = entities.indexOf(result)
                require(index != -1)
                entities[index] = result
            }
            else -> entities += result
        }
        return result
    }

    fun delete(entity: GameProjectPlatformEntity) {
        api.delete("game_project_platforms/delete", entity)
        entities -= entity
    }
}
