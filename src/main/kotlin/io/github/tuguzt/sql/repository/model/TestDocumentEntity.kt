package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.TestDocument
import tornadofx.JsonBuilder
import tornadofx.JsonModel
import tornadofx.jsonModel
import tornadofx.string
import javax.json.JsonObject

class TestDocumentEntity(override var data: String, override var level: TestLevelEntity) : TestDocument, JsonModel {
    override fun updateModel(json: JsonObject) = with(json) {
        data = requireNotNull(string("data"))
        level = requireNotNull(jsonModel("level"))
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("data", data)
        add("level", level)
    }
}
