package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.ObjectProperty
import io.github.tuguzt.sql.domain.model.Officer
import tornadofx.*
import javax.json.JsonObject

class OfficerEntity(name: String = "", role: OfficerRoleEntity = OfficerRoleEntity(), id: Int = 0) : Officer,
    JsonModel {
    private var _id: Int by property(id)
    override val id get() = _id

    private val _idProperty get() = getProperty(OfficerEntity::_id)
    val idProperty: ObjectProperty<Int> get() = _idProperty

    override var name: String by property(name)
    inline val nameProperty get() = getProperty(OfficerEntity::name)

    override var role: OfficerRoleEntity by property(role)
    inline val roleProperty get() = getProperty(OfficerEntity::role)

    override fun updateModel(json: JsonObject) = with(json) {
        _id = requireNotNull(int("id"))
        name = requireNotNull(string("name"))
        role = requireNotNull(jsonModel("role"))
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("id", id)
        add("name", name)
        add("role", role)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OfficerEntity
        return id == other.id
    }

    override fun hashCode() = id
}
