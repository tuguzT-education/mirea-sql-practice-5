package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.MutableProperty
import io.github.tuguzt.sql.repository.model.*
import tornadofx.*

class GameProjectModel(gameProject: GameProjectEntity) : ItemViewModel<GameProjectEntity>(gameProject) {
    val name: MutableProperty<String> = bind(GameProjectEntity::nameProperty)
    val description: MutableProperty<String> = bind(GameProjectEntity::descriptionProperty)
    val documentation: MutableProperty<GameProjectDocumentationEntity> = bind(GameProjectEntity::documentationProperty)
    val assets: MutableProperty<Set<GameAssetEntity>> = bind(GameProjectEntity::assetsProperty)
    val platforms: MutableProperty<Set<GameProjectPlatformEntity>> = bind(GameProjectEntity::platformsProperty)
    val versions: MutableProperty<Set<GameProjectVersionEntity>> = bind(GameProjectEntity::versionsProperty)
}
