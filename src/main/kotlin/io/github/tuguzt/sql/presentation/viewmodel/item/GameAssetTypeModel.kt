package io.github.tuguzt.sql.presentation.viewmodel.item

import io.github.tuguzt.sql.MutableProperty
import io.github.tuguzt.sql.repository.model.GameAssetTypeEntity
import tornadofx.*

class GameAssetTypeModel(gameAssetType: GameAssetTypeEntity) : ItemViewModel<GameAssetTypeEntity>(gameAssetType) {
    val name: MutableProperty<String> = bind(GameAssetTypeEntity::nameProperty)
}
