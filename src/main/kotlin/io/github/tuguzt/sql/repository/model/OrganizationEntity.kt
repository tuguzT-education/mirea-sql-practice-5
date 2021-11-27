package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.Organization
import tornadofx.*
import javax.json.JsonObject

class OrganizationEntity(
    override var name: String,
    override var description: String,
    override var type: OrganizationTypeEntity,
    override var testDocument: TestDocumentEntity?,
    override var gameProjects: Set<GameProjectEntity>,
    override var officers: Set<OfficerEntity>,
) : Organization, JsonModel {
    override fun updateModel(json: JsonObject) = with(json) {
        name = requireNotNull(string("name"))
        description = requireNotNull(string("description"))
        type = requireNotNull(jsonModel("type"))
        testDocument = jsonModel("test_document")
        gameProjects = requireNotNull(jsonArray("game_projects")).toModel<GameProjectEntity>().toSet()
        officers = requireNotNull(jsonArray("officers")).toModel<OfficerEntity>().toSet()
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("name", name)
        add("description", description)
        add("type", type)
        add("test_document", testDocument)
        add("game_projects", gameProjects.toJSON())
        add("officers", officers.toJSON())
    }
}
