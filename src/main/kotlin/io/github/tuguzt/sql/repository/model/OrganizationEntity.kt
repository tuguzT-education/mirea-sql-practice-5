package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.Organization
import javafx.collections.ObservableSet
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
) : Organization, JsonModel, ReadonlyIdEntity<Int>(id) {

    override var name: String by property(name)
    val nameProperty get() = getProperty(OrganizationEntity::name)

    override var description: String by property(description)
    val descriptionProperty get() = getProperty(OrganizationEntity::description)

    override var type: OrganizationTypeEntity by property(type)
    val typeProperty get() = getProperty(OrganizationEntity::type)

    override var testDocument: TestDocumentEntity? by property(testDocument)
    val testDocumentProperty get() = getProperty(OrganizationEntity::testDocument)

    override var gameProjects: ObservableSet<GameProjectEntity> by property(gameProjects.toObservable())
    val gameProjectsProperty get() = getProperty(OrganizationEntity::gameProjects)

    override var officers: ObservableSet<OfficerEntity> by property(officers.toObservable())
    val officersProperty get() = getProperty(OrganizationEntity::officers)

    override fun updateModel(json: JsonObject) = with(json) {
        _id = requireNotNull(int("id"))
        name = requireNotNull(string("name"))
        description = requireNotNull(string("description"))
        type = requireNotNull(jsonModel("type"))
        testDocument = jsonModel("test_document")
        gameProjects = (jsonArray("game_projects")?.toModel<GameProjectEntity>()?.toSet() ?: setOf()).toObservable()
        officers = (jsonArray("officers")?.toModel<OfficerEntity>()?.toSet() ?: setOf()).toObservable()
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("id", id)
        add("name", name)
        add("description", description)
        add("type", type)
        add("test_document", testDocument)
        add("game_projects", gameProjects)
        add("officers", officers)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OrganizationEntity
        return id == other.id
    }

    override fun hashCode() = id
}
