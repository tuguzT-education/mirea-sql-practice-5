package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.Organization
import tornadofx.*
import javax.json.JsonObject

class OrganizationEntity(
    name: String = "",
    description: String = "",
    type: OrganizationTypeEntity = OrganizationTypeEntity(),
    testDocument: TestDocumentEntity? = null,
    gameProjects: Set<GameProjectEntity> = setOf(),
    officers: Set<OfficerEntity> = setOf(),
    id: Int = 0,
) : Organization, JsonModel {
    private var _id = id
    override val id get() = _id

    override var name: String by property(name)
    inline val nameProperty get() = getProperty(OrganizationEntity::name)

    override var description: String by property(description)
    inline val descriptionProperty get() = getProperty(OrganizationEntity::description)

    override var type: OrganizationTypeEntity by property(type)
    inline val typeProperty get() = getProperty(OrganizationEntity::type)

    override var testDocument: TestDocumentEntity? by property(testDocument)
    inline val testDocumentProperty get() = getProperty(OrganizationEntity::testDocument)

    override var gameProjects: Set<GameProjectEntity> by property(gameProjects)
    inline val gameProjectsProperty get() = getProperty(OrganizationEntity::gameProjects)

    override var officers: Set<OfficerEntity> by property(officers)
    inline val officersProperty get() = getProperty(OrganizationEntity::officers)

    override fun updateModel(json: JsonObject) = with(json) {
        _id = requireNotNull(int("id"))
        name = requireNotNull(string("name"))
        description = requireNotNull(string("description"))
        type = requireNotNull(jsonModel("type"))
        testDocument = jsonModel("test_document")
        gameProjects = requireNotNull(jsonArray("game_projects")).toModel<GameProjectEntity>().toSet()
        officers = requireNotNull(jsonArray("officers")).toModel<OfficerEntity>().toSet()
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("id", id)
        add("name", name)
        add("description", description)
        add("type", type)
        add("test_document", testDocument)
        add("game_projects", gameProjects.toJSON())
        add("officers", officers.toJSON())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OrganizationEntity
        return id == other.id
    }

    override fun hashCode() = id
}
