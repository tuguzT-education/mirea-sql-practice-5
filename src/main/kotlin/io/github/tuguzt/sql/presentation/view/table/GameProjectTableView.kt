package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.empty
import io.github.tuguzt.sql.presentation.view.edit.GameProjectEditFragment
import io.github.tuguzt.sql.presentation.view.show.GameProjectShowFragment
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectTableModel
import io.github.tuguzt.sql.repository.model.GameProjectEntity
import javafx.scene.control.TableRow
import tornadofx.*

class GameProjectTableView : View(FX.messages["game_projects"]) {
    private val model: GameProjectTableModel by inject()
    private val itemModel = GameProjectModel(GameProjectEntity())

    override val root = tableview(model.gameProjects) {
        isEditable = true
        setRowFactory {
            TableRow<GameProjectEntity?>().apply {
                fun editItem() {
                    openInternalWindow(GameProjectEditFragment(itemModel), movable = false, closeButton = false)
                }

                fun showItem() {
                    openInternalWindow(GameProjectShowFragment(itemModel), movable = false)
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

        column("#", GameProjectEntity::idProperty)
        column(messages["name"], GameProjectEntity::nameProperty)
        column(messages["description"], GameProjectEntity::descriptionProperty)
        column(messages["documentation"], GameProjectEntity::documentationProperty)

        itemModel.rebindOnChange(this) { selected ->
            item = selected ?: GameProjectEntity()
        }
    }
}
