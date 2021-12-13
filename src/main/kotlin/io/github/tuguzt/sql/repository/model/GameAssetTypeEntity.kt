package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.GameAssetType
import tornadofx.*
import javax.json.JsonObject

class GameAssetTypeEntity(name: String = "", id: Int = 0) : GameAssetType, JsonModel, ReadonlyIdEntity<Int>(id) {
    override var name: String by property(name)
    val nameProperty get() = getProperty(GameAssetTypeEntity::name)

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

        other as GameAssetTypeEntity
        return id == other.id
    }

    override fun hashCode() = id
}
