package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.repository.model.GameProjectPlatformEntity
import javafx.beans.property.Property
import tornadofx.ItemViewModel

class GameProjectPlatformModel(gameProjectPlatform: GameProjectPlatformEntity) :
    ItemViewModel<GameProjectPlatformEntity>(gameProjectPlatform) {
    val name: Property<String> = bind(GameProjectPlatformEntity::nameProperty)
}
