package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.repository.model.GameAssetEntity
import io.github.tuguzt.sql.repository.model.GameAssetTypeEntity
import javafx.beans.property.Property
import tornadofx.ItemViewModel

class GameAssetModel(gameAsset: GameAssetEntity) : ItemViewModel<GameAssetEntity>(gameAsset) {
    val dataUri: Property<String> = bind(GameAssetEntity::dataUriProperty)
    val description: Property<String> = bind(GameAssetEntity::descriptionProperty)
    val name: Property<String> = bind(GameAssetEntity::nameProperty)
    val type: Property<GameAssetTypeEntity> = bind(GameAssetEntity::typeProperty)
}
