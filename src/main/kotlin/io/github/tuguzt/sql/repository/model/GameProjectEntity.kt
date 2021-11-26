package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.GameProject

class GameProjectEntity(
    override val assets: Set<GameAssetEntity>,
    override val description: String,
    override val documentation: GameProjectDocumentationEntity,
    override val name: String,
    override val platforms: Set<GameProjectPlatformEntity>,
    override val versions: Set<GameProjectVersionEntity>,
) : GameProject
