package io.github.tuguzt.sql.presentation.view

import io.github.tuguzt.sql.presentation.viewmodel.GameAssetModel
import io.github.tuguzt.sql.repository.model.GameAssetEntity
import io.github.tuguzt.sql.repository.model.GameAssetTypeEntity
import tornadofx.*

class GameAssetTableFragment : Fragment() {
    private val assets = listOf(
        GameAssetEntity("Hello", "Some shit", "idk", GameAssetTypeEntity("World")),
    ).toObservable()
    private val model = GameAssetModel(GameAssetEntity())

    override val root = tableview(assets) {
        column("Name", GameAssetEntity::nameProperty)
        column("Description", GameAssetEntity::descriptionProperty)
        column("Data URI", GameAssetEntity::dataUriProperty)
        column("Type", GameAssetEntity::typeProperty)

        model.rebindOnChange(this) { selected ->
            item = selected ?: GameAssetEntity()
        }
    }
}
