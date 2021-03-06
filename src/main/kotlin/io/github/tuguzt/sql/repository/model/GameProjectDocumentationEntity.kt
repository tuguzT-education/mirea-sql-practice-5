package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.GameProjectDocumentation
import tornadofx.*
import javax.json.JsonObject

class GameProjectDocumentationEntity(
    businessPlan: String = "",
    designDocument: String = "",
    vision: String = "",
    id: Int = 0,
) : GameProjectDocumentation, JsonModel, ReadonlyIdEntity<Int>(id) {

    override var businessPlan: String by property(businessPlan)
    val businessPlanProperty get() = getProperty(GameProjectDocumentationEntity::businessPlan)

    override var designDocument: String by property(designDocument)
    val designDocumentProperty get() = getProperty(GameProjectDocumentationEntity::designDocument)

    override var vision: String by property(vision)
    val visionProperty get() = getProperty(GameProjectDocumentationEntity::vision)

    override fun updateModel(json: JsonObject) = with(json) {
        _id = requireNotNull(int("id"))
        businessPlan = requireNotNull(string("business_plan"))
        designDocument = requireNotNull(string("design_document"))
        vision = requireNotNull(string("vision"))
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("id", id)
        add("business_plan", businessPlan)
        add("design_document", designDocument)
        add("vision", vision)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GameProjectDocumentationEntity
        return id == other.id
    }

    override fun hashCode() = id
}
