package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.TestLevel
import tornadofx.*
import javax.json.JsonObject

class TestLevelEntity(name: String = "", id: Int = 0) : TestLevel, JsonModel {
    private var _id = id
    override val id get() = _id

    override var name: String by property(name)
    inline val nameProperty get() = getProperty(TestLevelEntity::name)

    override fun updateModel(json: JsonObject) = with(json) {
        _id = requireNotNull(int("id"))
        name = requireNotNull(string("name"))
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("id", id)
        add("name", name)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TestLevelEntity
        return id == other.id
    }

    override fun hashCode() = id
}
