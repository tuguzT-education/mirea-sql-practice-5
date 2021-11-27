package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.Officer
import tornadofx.*
import javax.json.JsonObject

class OfficerEntity(name: String = "", role: OfficerRoleEntity = OfficerRoleEntity()) : Officer, JsonModel {
    override var name: String by property(name)
    inline val nameProperty get() = getProperty(OfficerEntity::name)

    override var role: OfficerRoleEntity by property(role)
    inline val roleProperty get() = getProperty(OfficerEntity::role)

    override fun updateModel(json: JsonObject) = with(json) {
        name = requireNotNull(string("name"))
        role = requireNotNull(jsonModel("role"))
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("name", name)
        add("role", role)
    }
}
