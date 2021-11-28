package io.github.tuguzt.sql.presentation.viewmodel.item

import io.github.tuguzt.sql.MutableProperty
import io.github.tuguzt.sql.repository.model.GameAssetEntity
import io.github.tuguzt.sql.repository.model.GameAssetTypeEntity
import tornadofx.*

class GameAssetModel(gameAsset: GameAssetEntity) : ItemViewModel<GameAssetEntity>(gameAsset) {
    val dataUri: MutableProperty<String> = bind(GameAssetEntity::dataUriProperty)
    val description: MutableProperty<String> = bind(GameAssetEntity::descriptionProperty)
    val name: MutableProperty<String> = bind(GameAssetEntity::nameProperty)
    val type: MutableProperty<GameAssetTypeEntity> = bind(GameAssetEntity::typeProperty)
}
