package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameProjectDocumentationEntity
import tornadofx.*

class GameProjectDocumentationTableModel : ViewModel() {
    private val api: Rest by inject()

    val entities = observableListOf<GameProjectDocumentationEntity>()

    fun updateAll() {
        val result = api.get("game_project_documentations/all").list().toModel<GameProjectDocumentationEntity>()
        entities.setAll(result)
    }

    fun save(entity: GameProjectDocumentationEntity): GameProjectDocumentationEntity {
        val result = api.post("game_project_documentations/save", entity).one()
            .toModel<GameProjectDocumentationEntity>()
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

    fun delete(entity: GameProjectDocumentationEntity) {
        api.delete("game_project_documentations/delete", entity)
        entities -= entity
    }
}
