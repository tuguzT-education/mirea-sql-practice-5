package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameProjectEntity
import tornadofx.*

class GameProjectTableModel : ViewModel() {
    private val api: Rest by inject()

    val entities = observableListOf<GameProjectEntity>()

    fun updateAll() {
        val result = api.get("game_projects/all").list().toModel<GameProjectEntity>()
        entities.setAll(result)
    }

    fun save(entity: GameProjectEntity): GameProjectEntity {
        val result = api.post("game_projects/save", entity).one().toModel<GameProjectEntity>()
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

    fun delete(entity: GameProjectEntity) {
        api.delete("game_projects/delete", entity)
        entities -= entity
    }
}
