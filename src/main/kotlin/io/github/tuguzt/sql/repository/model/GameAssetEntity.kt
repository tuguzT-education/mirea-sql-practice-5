package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.GameAsset
import tornadofx.JsonBuilder
import tornadofx.JsonModel
import tornadofx.jsonModel
import tornadofx.string
import javax.json.JsonObject

class GameAssetEntity(
    override var dataUri: String,
    override var description: String,
    override var name: String,
    override var type: GameAssetTypeEntity,
) : GameAsset, JsonModel {
    override fun updateModel(json: JsonObject) = with(json) {
        dataUri = requireNotNull(string("data_uri"))
        description = requireNotNull(string("description"))
        name = requireNotNull(string("name"))
        type = requireNotNull(jsonModel("type"))
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("data_uri", dataUri)
        add("description", description)
        add("name", name)
        add("type", type)
    }
}
