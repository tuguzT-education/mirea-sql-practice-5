package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.GameProject
import javafx.collections.ObservableSet
import tornadofx.*
import javax.json.JsonObject

class GameProjectEntity(
    name: String = "",
    description: String = "",
    documentation: GameProjectDocumentationEntity = GameProjectDocumentationEntity(),
    assets: Set<GameAssetEntity> = setOf(),
    platforms: Set<GameProjectPlatformEntity> = setOf(),
    versions: Set<GameProjectVersionEntity> = setOf(),
    organizations: Set<OrganizationEntity> = setOf(),
    id: Int = 0,
) : GameProject, JsonModel, ReadonlyIdEntity<Int>(id) {

    override var name: String by property(name)
    val nameProperty get() = getProperty(GameProjectEntity::name)

    override var description: String by property(description)
    val descriptionProperty get() = getProperty(GameProjectEntity::description)

    override var documentation: GameProjectDocumentationEntity by property(documentation)
    val documentationProperty get() = getProperty(GameProjectEntity::documentation)

    override var assets: ObservableSet<GameAssetEntity> by property(assets.toObservable())
    val assetsProperty get() = getProperty(GameProjectEntity::assets)

    override var platforms: ObservableSet<GameProjectPlatformEntity> by property(platforms.toObservable())
    val platformsProperty get() = getProperty(GameProjectEntity::platforms)

    override var versions: ObservableSet<GameProjectVersionEntity> by property(versions.toObservable())
    val versionsProperty get() = getProperty(GameProjectEntity::versions)

    override var organizations: ObservableSet<OrganizationEntity> by property(organizations.toObservable())
    val organizationsProperty get() = getProperty(GameProjectEntity::organizations)

    override fun updateModel(json: JsonObject) = with(json) {
        _id = requireNotNull(int("id"))
        name = requireNotNull(string("name"))
        description = requireNotNull(string("description"))
        documentation = requireNotNull(jsonModel("documentation"))
        assets = (jsonArray("assets")?.toModel<GameAssetEntity>()?.toSet() ?: setOf()).toObservable()
        platforms = (jsonArray("platforms")?.toModel<GameProjectPlatformEntity>()?.toSet() ?: setOf()).toObservable()
        versions = (jsonArray("versions")?.toModel<GameProjectVersionEntity>()?.toSet() ?: setOf()).toObservable()
        organizations = (jsonArray("organizations")?.toModel<OrganizationEntity>()?.toSet() ?: setOf()).toObservable()
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("id", id)
        add("name", name)
        add("description", description)
        add("documentation", documentation)
        add("assets", assets)
        add("platforms", platforms)
        add("versions", versions)
        add("organizations", organizations)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GameProjectEntity
        return id == other.id
    }

    override fun hashCode() = id
}
