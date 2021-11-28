package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.GameProject
import tornadofx.*
import javax.json.JsonObject

class GameProjectEntity(
    name: String = "",
    description: String = "",
    documentation: GameProjectDocumentationEntity = GameProjectDocumentationEntity(),
    assets: Set<GameAssetEntity> = setOf(),
    platforms: Set<GameProjectPlatformEntity> = setOf(),
    versions: Set<GameProjectVersionEntity> = setOf(),
    id: Int = 0,
) : GameProject, JsonModel {
    private var _id = id
    override val id get() = _id

    override var name: String by property(name)
    inline val nameProperty get() = getProperty(GameProjectEntity::name)

    override var description: String by property(description)
    inline val descriptionProperty get() = getProperty(GameProjectEntity::description)

    override var documentation: GameProjectDocumentationEntity by property(documentation)
    inline val documentationProperty get() = getProperty(GameProjectEntity::documentation)

    override var assets: Set<GameAssetEntity> by property(assets)
    inline val assetsProperty get() = getProperty(GameProjectEntity::assets)

    override var platforms: Set<GameProjectPlatformEntity> by property(platforms)
    inline val platformsProperty get() = getProperty(GameProjectEntity::platforms)

    override var versions: Set<GameProjectVersionEntity> by property(versions)
    inline val versionsProperty get() = getProperty(GameProjectEntity::versions)

    override fun updateModel(json: JsonObject) = with(json) {
        _id = requireNotNull(int("id"))
        name = requireNotNull(string("name"))
        description = requireNotNull(string("description"))
        documentation = requireNotNull(jsonModel("documentation"))
        assets = requireNotNull(jsonArray("assets")).toModel<GameAssetEntity>().toSet()
        platforms = requireNotNull(jsonArray("platforms")).toModel<GameProjectPlatformEntity>().toSet()
        versions = requireNotNull(jsonArray("versions")).toModel<GameProjectVersionEntity>().toSet()
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("id", id)
        add("name", name)
        add("description", description)
        add("documentation", documentation)
        add("assets", assets.toJSON())
        add("platforms", platforms.toJSON())
        add("versions", versions.toJSON())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GameProjectEntity
        return id == other.id
    }

    override fun hashCode() = id
}
