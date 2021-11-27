package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.OfficerRole
import tornadofx.*
import javax.json.JsonObject

class OfficerRoleEntity(name: String = "") : OfficerRole, JsonModel {
    override var name: String by property(name)
    inline val nameProperty get() = getProperty(OfficerRoleEntity::name)

    override fun updateModel(json: JsonObject) = with(json) {
        name = requireNotNull(string("name"))
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("name", name)
    }
}
