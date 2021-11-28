package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.ObjectProperty
import io.github.tuguzt.sql.domain.model.GameAssetType
import tornadofx.*
import javax.json.JsonObject

class GameAssetTypeEntity(name: String = "", id: Int = 0) : GameAssetType, JsonModel {
    private var _id: Int by property(id)
    override val id get() = _id

    private val _idProperty get() = getProperty(GameAssetTypeEntity::_id)
    val idProperty: ObjectProperty<Int> get() = _idProperty

    override var name: String by property(name)
    inline val nameProperty get() = getProperty(GameAssetTypeEntity::name)

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
