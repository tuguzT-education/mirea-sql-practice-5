package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.MutableProperty
import io.github.tuguzt.sql.repository.model.GameProjectVersionEntity
import tornadofx.*

class GameProjectVersionModel(gameProjectVersion: GameProjectVersionEntity) :
    ItemViewModel<GameProjectVersionEntity>(gameProjectVersion) {
    val hash: MutableProperty<String> = bind(GameProjectVersionEntity::hashProperty)
    val major: MutableProperty<Int> = bind(GameProjectVersionEntity::majorProperty)
    val minor: MutableProperty<Int> = bind(GameProjectVersionEntity::minorProperty)
    val patch: MutableProperty<Int> = bind(GameProjectVersionEntity::patchProperty)
    val metadata: MutableProperty<String> = bind(GameProjectVersionEntity::metadataProperty)
}
