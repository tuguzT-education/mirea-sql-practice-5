package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.GameAssetType
import tornadofx.JsonBuilder
import tornadofx.JsonModel
import tornadofx.string
import javax.json.JsonObject

class GameAssetTypeEntity(override var name: String) : GameAssetType, JsonModel {
    override fun updateModel(json: JsonObject) = with(json) {
        name = requireNotNull(string("name"))
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("name", name)
    }
}
