package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.empty
import io.github.tuguzt.sql.presentation.view.edit.GameProjectVersionEditFragment
import io.github.tuguzt.sql.presentation.view.show.GameProjectVersionShowFragment
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectVersionModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectVersionTableModel
import io.github.tuguzt.sql.repository.model.GameProjectVersionEntity
import javafx.scene.control.TableRow
import tornadofx.*

class GameProjectVersionTableView : View(FX.messages["game_project_versions"]) {
    private val model: GameProjectVersionTableModel by inject()
    private val itemModel = GameProjectVersionModel(GameProjectVersionEntity())

    override val root = tableview(model.entities) {
        isEditable = true
        setRowFactory {
            TableRow<GameProjectVersionEntity?>().apply {
                fun editItem() {
                    openInternalWindow(GameProjectVersionEditFragment(itemModel), movable = false, closeButton = false)
                }

                fun showItem() {
                    openInternalWindow(GameProjectVersionShowFragment(itemModel), movable = false)
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

        column("#", GameProjectVersionEntity::idProperty)
        column(messages["hash"], GameProjectVersionEntity::hashProperty)
        column(messages["major"], GameProjectVersionEntity::majorProperty)
        column(messages["minor"], GameProjectVersionEntity::minorProperty)
        column(messages["patch"], GameProjectVersionEntity::patchProperty)
        column(messages["metadata"], GameProjectVersionEntity::metadataProperty)

        itemModel.rebindOnChange(this) { selected ->
            item = selected ?: GameProjectVersionEntity()
        }
    }
}
