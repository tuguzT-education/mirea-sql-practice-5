package io.github.tuguzt.sql.presentation.viewmodel.item

import io.github.tuguzt.sql.MutableProperty
import io.github.tuguzt.sql.repository.model.GameProjectEntity
import io.github.tuguzt.sql.repository.model.GameProjectPlatformEntity
import tornadofx.*

class GameProjectPlatformModel(gameProjectPlatform: GameProjectPlatformEntity) :
    ItemViewModel<GameProjectPlatformEntity>(gameProjectPlatform) {
    val name: MutableProperty<String> = bind(GameProjectPlatformEntity::nameProperty)
    val gameProjects: MutableProperty<Set<GameProjectEntity>> = bind(GameProjectPlatformEntity::gameProjectProperty)
}
