package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.TestLevel
import tornadofx.JsonBuilder
import tornadofx.JsonModel
import tornadofx.string
import javax.json.JsonObject

class TestLevelEntity(override var name: String) : TestLevel, JsonModel {
    override fun updateModel(json: JsonObject) = with(json) {
        name = requireNotNull(string("name"))
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("name", name)
    }
}
