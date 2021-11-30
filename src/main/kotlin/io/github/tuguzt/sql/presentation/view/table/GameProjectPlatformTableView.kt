package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.empty
import io.github.tuguzt.sql.presentation.view.edit.GameProjectPlatformEditFragment
import io.github.tuguzt.sql.presentation.view.show.GameProjectPlatformShowFragment
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectPlatformModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectPlatformTableModel
import io.github.tuguzt.sql.repository.model.GameProjectPlatformEntity
import javafx.scene.control.TableRow
import tornadofx.*

class GameProjectPlatformTableView : View(FX.messages["game_project_platforms"]) {
    private val model: GameProjectPlatformTableModel by inject()
    private val itemModel = GameProjectPlatformModel(GameProjectPlatformEntity())

    override val root = tableview(model.platforms) {
        isEditable = true
        setRowFactory {
            TableRow<GameProjectPlatformEntity?>().apply {
                fun editItem() {
                    openInternalWindow(GameProjectPlatformEditFragment(itemModel), movable = false, closeButton = false)
                }

                fun showItem() {
                    openInternalWindow(GameProjectPlatformShowFragment(itemModel), movable = false)
                }

                onDoubleClick {
                    if (isEmpty) return@onDoubleClick
                    showItem()
                }
                contextmenu {
                    disableWhen(empty)
                    item(messages["show"]).action(::showItem)
                    item(messages["edit"]).action(::editItem)
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
