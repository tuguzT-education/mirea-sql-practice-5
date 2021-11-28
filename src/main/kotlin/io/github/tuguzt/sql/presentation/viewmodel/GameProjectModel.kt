package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.repository.model.*
import javafx.beans.property.Property
import tornadofx.*

class GameProjectModel(gameProject: GameProjectEntity) : ItemViewModel<GameProjectEntity>(gameProject) {
    val name: Property<String> = bind(GameProjectEntity::nameProperty)
    val description: Property<String> = bind(GameProjectEntity::descriptionProperty)
    val documentation: Property<GameProjectDocumentationEntity> = bind(GameProjectEntity::documentationProperty)
    val assets: Property<Set<GameAssetEntity>> = bind(GameProjectEntity::assetsProperty)
    val platforms: Property<Set<GameProjectPlatformEntity>> = bind(GameProjectEntity::platformsProperty)
    val versions: Property<Set<GameProjectVersionEntity>> = bind(GameProjectEntity::versionsProperty)
}
