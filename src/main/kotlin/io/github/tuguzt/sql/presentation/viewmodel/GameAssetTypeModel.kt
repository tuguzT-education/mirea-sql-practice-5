package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.repository.model.GameAssetTypeEntity
import javafx.beans.property.Property
import tornadofx.ItemViewModel

class GameAssetTypeModel(gameAssetType: GameAssetTypeEntity) : ItemViewModel<GameAssetTypeEntity>(gameAssetType) {
    val name: Property<String> = bind(GameAssetTypeEntity::nameProperty)
}
