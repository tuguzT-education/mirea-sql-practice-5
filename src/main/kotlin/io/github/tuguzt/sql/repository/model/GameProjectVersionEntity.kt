package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.GameProjectVersion

class GameProjectVersionEntity(
    override val hash: String,
    override val major: Int,
    override val metadata: String,
    override val minor: Int,
    override val patch: Int,
) : GameProjectVersion
