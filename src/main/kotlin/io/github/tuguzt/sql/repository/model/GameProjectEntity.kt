package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.GameProject
import tornadofx.*
import javax.json.JsonObject

class GameProjectEntity(
    override var name: String,
    override var description: String,
    override var documentation: GameProjectDocumentationEntity,
    override var assets: Set<GameAssetEntity>,
    override var platforms: Set<GameProjectPlatformEntity>,
    override var versions: Set<GameProjectVersionEntity>,
) : GameProject, JsonModel {
    override fun updateModel(json: JsonObject) = with(json) {
        name = requireNotNull(string("name"))
        description = requireNotNull(string("description"))
        documentation = requireNotNull(jsonModel("documentation"))
        assets = requireNotNull(jsonArray("assets")).toModel<GameAssetEntity>().toSet()
        platforms = requireNotNull(jsonArray("platforms")).toModel<GameProjectPlatformEntity>().toSet()
        versions = requireNotNull(jsonArray("versions")).toModel<GameProjectVersionEntity>().toSet()
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("name", name)
        add("description", description)
        add("documentation", documentation)
        add("assets", assets.toJSON())
        add("platforms", platforms.toJSON())
        add("versions", versions.toJSON())
    }
}
