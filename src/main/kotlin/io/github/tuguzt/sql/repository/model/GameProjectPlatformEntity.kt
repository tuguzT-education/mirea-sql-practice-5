package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.GameProjectPlatform
import javafx.collections.ObservableSet
import tornadofx.*
import javax.json.JsonObject

class GameProjectPlatformEntity(
    name: String = "",
    gameProjects: Set<GameProjectEntity> = setOf(),
    id: Int = 0,
) : GameProjectPlatform, JsonModel, ReadonlyIdEntity<Int>(id) {

    override var name: String by property(name)
    val nameProperty get() = getProperty(GameProjectPlatformEntity::name)

    override var gameProjects: ObservableSet<GameProjectEntity> by property(gameProjects.toObservable())
    val gameProjectsProperty get() = getProperty(GameProjectPlatformEntity::gameProjects)

    override fun updateModel(json: JsonObject) = with(json) {
        _id = requireNotNull(int("id"))
        name = requireNotNull(string("name"))
        gameProjects = (jsonArray("game_projects")?.toModel<GameProjectEntity>()?.toSet() ?: setOf()).toObservable()
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("id", id)
        add("name", name)
        add("game_projects", gameProjects)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GameProjectPlatformEntity
        return id == other.id
    }

    override fun hashCode() = id
}
