package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.empty
import io.github.tuguzt.sql.presentation.view.create.GameProjectPlatformCreateFragment
import io.github.tuguzt.sql.presentation.view.dialog.ConfirmDialog
import io.github.tuguzt.sql.presentation.view.dialog.OkDialog
import io.github.tuguzt.sql.presentation.view.edit.GameProjectPlatformEditFragment
import io.github.tuguzt.sql.presentation.view.show.GameProjectPlatformShowFragment
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectPlatformModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectPlatformTableModel
import io.github.tuguzt.sql.repository.model.GameProjectPlatformEntity
import javafx.scene.control.TableRow
import tornadofx.*

class GameProjectPlatformTableView : EntityTableView<GameProjectPlatformEntity>(FX.messages["game_project_platforms"]) {
    override val model: GameProjectPlatformTableModel by inject()
    override val itemModel = GameProjectPlatformModel(GameProjectPlatformEntity())

    override val createFragmentFactory = ::GameProjectPlatformCreateFragment
    override val editFragmentFactory = { GameProjectPlatformEditFragment(itemModel) }

    override val root = tableview(model.entities) {
        isEditable = true
        setRowFactory {
            TableRow<GameProjectPlatformEntity?>().apply {
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

        column("#", GameProjectPlatformEntity::idProperty)
        column(messages["name"], GameProjectPlatformEntity::nameProperty)

        itemModel.rebindOnChange(this) { selected ->
            item = selected ?: GameProjectPlatformEntity()
        }
    }
}
