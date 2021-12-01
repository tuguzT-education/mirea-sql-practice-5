package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.ObjectProperty
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
) : GameProject, JsonModel {
    private var _id: Int by property(id)
    override val id get() = _id

    private val _idProperty get() = getProperty(GameProjectEntity::_id)
    val idProperty: ObjectProperty<Int> get() = _idProperty

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
        assets = requireNotNull(jsonArray("assets")).toModel<GameAssetEntity>().toSet().toObservable()
        platforms = requireNotNull(jsonArray("platforms")).toModel<GameProjectPlatformEntity>().toSet().toObservable()
        versions = requireNotNull(jsonArray("versions")).toModel<GameProjectVersionEntity>().toSet().toObservable()
        organizations = requireNotNull(jsonArray("organizations")).toModel<OrganizationEntity>().toSet().toObservable()
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("id", id)
        add("name", name)
        add("description", description)
        add("documentation", documentation)
        add("assets", assets.toJSON())
        add("platforms", platforms.toJSON())
        add("versions", versions.toJSON())
        add("organizations", organizations.toJSON())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GameProjectEntity
        return id == other.id
    }

    override fun hashCode() = id
}
