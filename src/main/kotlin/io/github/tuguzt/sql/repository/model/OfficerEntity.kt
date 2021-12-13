package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.Officer
import tornadofx.*
import javax.json.JsonObject

class OfficerEntity(
    name: String = "",
    role: OfficerRoleEntity = OfficerRoleEntity(),
    organization: OrganizationEntity = OrganizationEntity(),
    id: Int = 0,
) : Officer, JsonModel, ReadonlyIdEntity<Int>(id) {

    override var name: String by property(name)
    val nameProperty get() = getProperty(OfficerEntity::name)

    override var role: OfficerRoleEntity by property(role)
    val roleProperty get() = getProperty(OfficerEntity::role)

    override var organization: OrganizationEntity by property(organization)
    val organizationProperty get() = getProperty(OfficerEntity::organization)

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
