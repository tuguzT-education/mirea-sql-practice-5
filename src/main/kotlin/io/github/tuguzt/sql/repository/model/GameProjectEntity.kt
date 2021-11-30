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
    assets: ObservableSet<GameAssetEntity> = observableSetOf(),
    platforms: ObservableSet<GameProjectPlatformEntity> = observableSetOf(),
    versions: ObservableSet<GameProjectVersionEntity> = observableSetOf(),
    id: Int = 0,
) : GameProject, JsonModel {
    private var _id: Int by property(id)
    override val id get() = _id

    private val _idProperty get() = getProperty(GameProjectEntity::_id)
    val idProperty: ObjectProperty<Int> get() = _idProperty

    override var name: String by property(name)
    inline val nameProperty get() = getProperty(GameProjectEntity::name)

    override var description: String by property(description)
    inline val descriptionProperty get() = getProperty(GameProjectEntity::description)

    override var documentation: GameProjectDocumentationEntity by property(documentation)
    inline val documentationProperty get() = getProperty(GameProjectEntity::documentation)

    override var assets: ObservableSet<GameAssetEntity> by property(assets)
    inline val assetsProperty get() = getProperty(GameProjectEntity::assets)

    override var platforms: ObservableSet<GameProjectPlatformEntity> by property(platforms)
    inline val platformsProperty get() = getProperty(GameProjectEntity::platforms)

    override var versions: ObservableSet<GameProjectVersionEntity> by property(versions)
    inline val versionsProperty get() = getProperty(GameProjectEntity::versions)

    override fun updateModel(json: JsonObject) = with(json) {
        _id = requireNotNull(int("id"))
        name = requireNotNull(string("name"))
        description = requireNotNull(string("description"))
        documentation = requireNotNull(jsonModel("documentation"))
        assets = requireNotNull(jsonArray("assets")).toModel<GameAssetEntity>().toSet().toObservable()
        platforms = requireNotNull(jsonArray("platforms")).toModel<GameProjectPlatformEntity>().toSet().toObservable()
        versions = requireNotNull(jsonArray("versions")).toModel<GameProjectVersionEntity>().toSet().toObservable()
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
