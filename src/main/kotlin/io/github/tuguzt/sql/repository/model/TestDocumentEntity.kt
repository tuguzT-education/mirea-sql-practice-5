package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.TestDocument
import tornadofx.*
import javax.json.JsonObject

class TestDocumentEntity(data: String = "", level: TestLevelEntity = TestLevelEntity(), id: Int = 0) : TestDocument,
    JsonModel {
    private var _id = id
    override val id get() = _id

    override var data: String by property(data)
    inline val dataProperty get() = getProperty(TestDocumentEntity::data)

    override var level: TestLevelEntity by property(level)
    inline val levelProperty get() = getProperty(TestDocumentEntity::level)

    override fun updateModel(json: JsonObject) = with(json) {
        _id = requireNotNull(int("id"))
        data = requireNotNull(string("data"))
        level = requireNotNull(jsonModel("level"))
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("id", id)
        add("data", data)
        add("level", level)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TestDocumentEntity
        return id == other.id
    }

    override fun hashCode() = id
}
