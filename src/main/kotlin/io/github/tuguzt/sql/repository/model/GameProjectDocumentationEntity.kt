package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.GameProjectDocumentation
import tornadofx.*
import javax.json.JsonObject

class GameProjectDocumentationEntity(
    businessPlan: String = "",
    designDocument: String = "",
    vision: String = "",
) : GameProjectDocumentation, JsonModel {
    override var businessPlan: String by property(businessPlan)
    inline val businessPlanProperty get() = getProperty(GameProjectDocumentationEntity::businessPlan)

    override var designDocument: String by property(designDocument)
    inline val designDocumentProperty get() = getProperty(GameProjectDocumentationEntity::designDocument)

    override var vision: String by property(vision)
    inline val visionProperty get() = getProperty(GameProjectDocumentationEntity::vision)

    override fun updateModel(json: JsonObject) = with(json) {
        businessPlan = requireNotNull(string("business_plan"))
        designDocument = requireNotNull(string("design_document"))
        vision = requireNotNull(string("vision"))
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("business_plan", businessPlan)
        add("design_document", designDocument)
        add("vision", vision)
    }
}
