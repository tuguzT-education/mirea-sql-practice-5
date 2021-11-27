package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.GameProjectDocumentation
import tornadofx.JsonBuilder
import tornadofx.JsonModel
import tornadofx.string
import javax.json.JsonObject

class GameProjectDocumentationEntity(
    override var businessPlan: String,
    override var designDocument: String,
    override var vision: String,
) : GameProjectDocumentation, JsonModel {
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
