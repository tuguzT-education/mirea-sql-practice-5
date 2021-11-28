package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.view.edit.GameAssetEditFragment
import io.github.tuguzt.sql.presentation.viewmodel.GameAssetModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameAssetTableModel
import io.github.tuguzt.sql.repository.model.GameAssetEntity
import javafx.scene.control.TableRow
import tornadofx.*

class GameAssetTableView : View(FX.messages["game_assets"]) {
    private val model: GameAssetTableModel by inject()
    private val itemModel = GameAssetModel(GameAssetEntity())

    override val root = tableview(model.assets) {
        isEditable = true
        setRowFactory {
            TableRow<GameAssetEntity?>().apply {
                onDoubleClick {
                    if (isEmpty) return@onDoubleClick
                    openInternalWindow(GameAssetEditFragment(itemModel), movable = false, closeButton = false)
                }
            }
        }

        column(messages["name"], GameAssetEntity::nameProperty)
        column(messages["description"], GameAssetEntity::descriptionProperty)
        column(messages["data"], GameAssetEntity::dataUriProperty)
        column(messages["type"], GameAssetEntity::typeProperty)

        itemModel.rebindOnChange(this) { selected ->
            item = selected ?: GameAssetEntity()
        }
    }
}
