package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.repository.model.GameProjectVersionEntity
import javafx.beans.property.Property
import tornadofx.ItemViewModel

class GameProjectVersionModel(gameProjectVersion: GameProjectVersionEntity) :
    ItemViewModel<GameProjectVersionEntity>(gameProjectVersion) {
    val hash: Property<String> = bind(GameProjectVersionEntity::hashProperty)
    val major: Property<Int> = bind(GameProjectVersionEntity::majorProperty)
    val minor: Property<Int> = bind(GameProjectVersionEntity::minorProperty)
    val patch: Property<Int> = bind(GameProjectVersionEntity::patchProperty)
    val metadata: Property<String> = bind(GameProjectVersionEntity::metadataProperty)
}
