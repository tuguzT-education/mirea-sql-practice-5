package io.github.tuguzt.sql.presentation.view

import io.github.tuguzt.sql.presentation.viewmodel.GameAssetModel
import io.github.tuguzt.sql.repository.model.GameAssetEntity
import io.github.tuguzt.sql.repository.model.GameAssetTypeEntity
import javafx.scene.control.TableRow
import tornadofx.*

class GameAssetTableView : View(FX.messages["game_assets"]) {
    private val assets = observableListOf(
        GameAssetEntity("Hello", "Some shit", "file:///file.txt", GameAssetTypeEntity("World")),
    )
    private val model = GameAssetModel(GameAssetEntity())

    override val root = tableview(assets) {
        isEditable = true
        setRowFactory {
            TableRow<GameAssetEntity?>().apply {
                onDoubleClick {
                    if (isEmpty) return@onDoubleClick
                    openInternalWindow(GameAssetEditFragment(model), movable = false, closeButton = false)
                }
            }
        }

        column(messages["name"], GameAssetEntity::nameProperty)
        column(messages["description"], GameAssetEntity::descriptionProperty)
        column(messages["data"], GameAssetEntity::dataUriProperty)
        column(messages["type"], GameAssetEntity::typeProperty)

        model.rebindOnChange(this) { selected ->
            item = selected ?: GameAssetEntity()
        }
    }
}
