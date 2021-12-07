package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameAssetTypeEntity
import tornadofx.*

class GameAssetTypeTableModel : ViewModel() {
    private val api: Rest by inject()

    val entities = observableListOf<GameAssetTypeEntity>()

    fun updateAll() {
        val result = api.get("game_asset_types/all").list().toModel<GameAssetTypeEntity>()
        entities.clear()
        entities += result
    }

    fun save(entity: GameAssetTypeEntity): GameAssetTypeEntity {
        val result = api.post("game_asset_types/save", entity).one().toModel<GameAssetTypeEntity>()
        if (result !in entities) entities += result
        return result
    }

    fun delete(entity: GameAssetTypeEntity) {
        api.delete("game_asset_types/delete", entity)
        entities -= entity
    }
}
