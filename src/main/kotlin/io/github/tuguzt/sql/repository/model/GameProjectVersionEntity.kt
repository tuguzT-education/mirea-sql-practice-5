package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.GameProjectVersion
import tornadofx.*
import javax.json.JsonObject

class GameProjectVersionEntity(
    hash: String = "",
    major: Int = 0,
    minor: Int = 0,
    patch: Int = 0,
    metadata: String = "",
    gameProject: GameProjectEntity = GameProjectEntity(),
    id: Int = 0,
) : GameProjectVersion, JsonModel, ReadonlyIdEntity<Int>(id) {

    override var hash: String by property(hash)
    val hashProperty get() = getProperty(GameProjectVersionEntity::hash)

    override var major: Int by property(major)
    val majorProperty get() = getProperty(GameProjectVersionEntity::major)

    override var minor: Int by property(minor)
    val minorProperty get() = getProperty(GameProjectVersionEntity::minor)

    override var patch: Int by property(patch)
    val patchProperty get() = getProperty(GameProjectVersionEntity::patch)

    override var metadata: String by property(metadata)
    val metadataProperty get() = getProperty(GameProjectVersionEntity::metadata)

    override var gameProject: GameProjectEntity by property(gameProject)
    val gameProjectProperty get() = getProperty(GameProjectVersionEntity::gameProject)

    override fun updateModel(json: JsonObject): Unit = with(json) {
        _id = requireNotNull(int("id"))
        hash = requireNotNull(string("hash"))
        major = requireNotNull(int("major"))
        minor = requireNotNull(int("minor"))
        patch = requireNotNull(int("patch"))
        metadata = requireNotNull(string("metadata"))
        val newGameProject = jsonModel<GameProjectEntity>("game_project")
        if (newGameProject != null && newGameProject.id != 0) gameProject = newGameProject
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("id", id)
        add("hash", hash)
        add("major", major)
        add("minor", minor)
        add("patch", patch)
        add("metadata", metadata)
        add("game_project", gameProject)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GameProjectVersionEntity
        return id == other.id
    }

    override fun hashCode() = id
}
