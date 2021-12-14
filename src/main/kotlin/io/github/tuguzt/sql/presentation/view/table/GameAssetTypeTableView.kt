package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.empty
import io.github.tuguzt.sql.presentation.view.create.EntityCreateFragment
import io.github.tuguzt.sql.presentation.view.create.GameAssetTypeCreateFragment
import io.github.tuguzt.sql.presentation.view.dialog.ConfirmDialog
import io.github.tuguzt.sql.presentation.view.dialog.OkDialog
import io.github.tuguzt.sql.presentation.view.edit.EntityEditFragment
import io.github.tuguzt.sql.presentation.view.edit.GameAssetTypeEditFragment
import io.github.tuguzt.sql.presentation.viewmodel.item.GameAssetTypeModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameAssetTypeTableModel
import io.github.tuguzt.sql.repository.model.GameAssetTypeEntity
import javafx.beans.binding.BooleanExpression
import javafx.beans.property.SimpleBooleanProperty
import javafx.scene.control.TableRow
import tornadofx.*

class GameAssetTypeTableView : EntityTableView<GameAssetTypeEntity>(FX.messages["game_asset_types"]) {
    override val model: GameAssetTypeTableModel by inject()
    override val itemModel = GameAssetTypeModel(GameAssetTypeEntity())

    override val createFragmentFactory = ::GameAssetTypeCreateFragment
    override val editFragmentFactory = { GameAssetTypeEditFragment(itemModel) }

    override val root = tableview(model.entities) {
        isEditable = true
        setRowFactory {
            TableRow<GameAssetTypeEntity?>().apply {
                onDoubleClick {
                    if (isEmpty) return@onDoubleClick
                    onEdit()
                }
                contextmenu {
                    disableWhen(empty)
                    item(messages["edit"]).action(::onEdit)
                    item(messages["remove"]).action(::onDelete)
                }
            }
        }

        column("#", GameAssetTypeEntity::idProperty)
        column(messages["name"], GameAssetTypeEntity::nameProperty)

        itemModel.rebindOnChange(this) { selected ->
            item = selected ?: GameAssetTypeEntity()
        }
    }
}
