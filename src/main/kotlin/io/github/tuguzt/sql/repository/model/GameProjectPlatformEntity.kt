package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.ObjectProperty
import io.github.tuguzt.sql.domain.model.GameProjectPlatform
import javafx.collections.ObservableSet
import tornadofx.*
import javax.json.JsonObject

class GameProjectPlatformEntity(
    name: String = "",
    gameProjects: Set<GameProjectEntity> = setOf(),
    id: Int = 0,
) : GameProjectPlatform, JsonModel {
    private var _id: Int by property(id)
    override val id get() = _id

    private val _idProperty get() = getProperty(GameProjectPlatformEntity::_id)
    val idProperty: ObjectProperty<Int> get() = _idProperty

    override var name: String by property(name)
    val nameProperty get() = getProperty(GameProjectPlatformEntity::name)

    override var gameProjects: ObservableSet<GameProjectEntity> by property(gameProjects.toObservable())
    val gameProjectProperty get() = getProperty(GameProjectPlatformEntity::gameProjects)

    override fun updateModel(json: JsonObject) = with(json) {
        _id = requireNotNull(int("id"))
        name = requireNotNull(string("name"))
        gameProjects = requireNotNull(jsonArray("game_projects")).toModel<GameProjectEntity>().toSet().toObservable()
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("id", id)
        add("name", name)
        add("game_projects", gameProjects.toJSON())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GameProjectPlatformEntity
        return id == other.id
    }

    override fun hashCode() = id
}
