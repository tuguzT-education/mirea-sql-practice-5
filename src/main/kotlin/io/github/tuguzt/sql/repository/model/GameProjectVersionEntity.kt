package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.GameProjectVersion
import tornadofx.JsonBuilder
import tornadofx.JsonModel
import tornadofx.int
import tornadofx.string
import javax.json.JsonObject

class GameProjectVersionEntity(
    override var hash: String,
    override var major: Int,
    override var minor: Int,
    override var patch: Int,
    override var metadata: String,
) : GameProjectVersion, JsonModel {
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
