package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.empty
import io.github.tuguzt.sql.presentation.view.create.GameProjectCreateFragment
import io.github.tuguzt.sql.presentation.view.dialog.ConfirmDialog
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

    override val root = borderpane {
        top = hbox(spacing = 8) {
            button(messages["refresh"]).action(::refresh)
            button(messages["add"]).action {
                openInternalWindow(GameProjectCreateFragment(), movable = false, closeButton = false)
            }
        }
        center = tableview(model.entities) {
            isEditable = true
            setRowFactory {
                TableRow<GameProjectEntity?>().apply {
                    fun editItem() {
                        openInternalWindow(GameProjectEditFragment(itemModel), movable = false, closeButton = false)
                    }

                    fun showItem() {
                        openInternalWindow(GameProjectShowFragment(itemModel), movable = false)
                    }

                    fun removeItem() {
                        val title = messages["delete_game_project"]
                        val text = messages["are_you_sure"]
                        val confirmDialog = ConfirmDialog(title, text) { model.delete(item!!) }
                        openInternalWindow(confirmDialog, movable = false, closeButton = false)
                    }

                    onDoubleClick {
                        if (isEmpty) return@onDoubleClick
                        showItem()
                    }
                    contextmenu {
                        disableWhen(empty)
                        item(messages["show"]).action(::showItem)
                        item(messages["edit"]).action(::editItem)
                        item(messages["remove"]).action(::removeItem)
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

    init {
        runAsync { model.updateAll() }
    }

    private fun refresh() {
        root.runAsyncWithOverlay(op = model::updateAll)
    }
}
