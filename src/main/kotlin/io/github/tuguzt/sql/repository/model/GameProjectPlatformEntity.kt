package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.GameProjectPlatform
import tornadofx.*
import javax.json.JsonObject

class GameProjectPlatformEntity(name: String = "") : GameProjectPlatform, JsonModel {
    override var name: String by property(name)
    inline val nameProperty get() = getProperty(GameProjectEntity::name)

    override fun updateModel(json: JsonObject) = with(json) {
        name = requireNotNull(string("name"))
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("name", name)
    }
}
