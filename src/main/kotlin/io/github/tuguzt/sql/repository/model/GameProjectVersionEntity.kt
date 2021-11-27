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
) : GameProjectVersion, JsonModel {
    override var hash: String by property(hash)
    inline val hashProperty get() = getProperty(GameProjectVersionEntity::hash)

    override var major: Int by property(major)
    inline val majorProperty get() = getProperty(GameProjectVersionEntity::major)

    override var minor: Int by property(minor)
    inline val minorProperty get() = getProperty(GameProjectVersionEntity::minor)

    override var patch: Int by property(patch)
    inline val patchProperty get() = getProperty(GameProjectVersionEntity::patch)

    override var metadata: String by property(metadata)
    inline val metadataProperty get() = getProperty(GameProjectVersionEntity::metadata)

    override fun updateModel(json: JsonObject) = with(json) {
        hash = requireNotNull(string("hash"))
        major = requireNotNull(int("major"))
        minor = requireNotNull(int("minor"))
        patch = requireNotNull(int("patch"))
        metadata = requireNotNull(string("metadata"))
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("hash", hash)
        add("major", major)
        add("minor", minor)
        add("patch", patch)
        add("metadata", metadata)
    }
}
