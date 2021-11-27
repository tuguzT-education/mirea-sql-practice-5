package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.TestDocument
import tornadofx.*
import javax.json.JsonObject

class TestDocumentEntity(data: String = "", level: TestLevelEntity = TestLevelEntity()) : TestDocument, JsonModel {
    override var data: String by property(data)
    inline val dataProperty get() = getProperty(TestDocumentEntity::data)

    override var level: TestLevelEntity by property(level)
    inline val levelProperty get() = getProperty(TestDocumentEntity::level)

    override fun updateModel(json: JsonObject) = with(json) {
        data = requireNotNull(string("data"))
        level = requireNotNull(jsonModel("level"))
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("data", data)
        add("level", level)
    }
}
