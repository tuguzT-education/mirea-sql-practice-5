package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.Officer
import tornadofx.*
import javax.json.JsonObject

class OfficerEntity(override var name: String, override var role: OfficerRoleEntity) : Officer, JsonModel {
    override fun updateModel(json: JsonObject) = with(json) {
        name = requireNotNull(string("name"))
        role = requireNotNull(jsonModel("role"))
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("name", name)
        add("role", role)
    }
}
