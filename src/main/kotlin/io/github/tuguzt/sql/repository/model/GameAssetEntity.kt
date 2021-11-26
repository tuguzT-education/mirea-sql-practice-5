package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.GameAsset

class GameAssetEntity(
    override val dataUri: String,
    override val description: String,
    override val name: String,
    override val type: GameAssetTypeEntity,
) : GameAsset
