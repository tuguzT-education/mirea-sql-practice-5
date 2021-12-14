package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.empty
import io.github.tuguzt.sql.presentation.view.converter.GameProjectDocumentationStringConverter
import io.github.tuguzt.sql.presentation.view.create.GameProjectCreateFragment
import io.github.tuguzt.sql.presentation.view.dialog.ConfirmDialog
import io.github.tuguzt.sql.presentation.view.dialog.OkDialog
import io.github.tuguzt.sql.presentation.view.edit.GameProjectEditFragment
import io.github.tuguzt.sql.presentation.view.show.GameProjectShowFragment
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectTableModel
import io.github.tuguzt.sql.repository.model.GameProjectEntity
import javafx.scene.control.TableRow
import tornadofx.*

// todo connect with workspace
class GameProjectTableView : View(FX.messages["game_projects"]) {
    private val model: GameProjectTableModel by inject()
    private val itemModel = GameProjectModel(GameProjectEntity())

    override val savable = booleanProperty()

    override val root = tableview(model.entities) {
        isEditable = true
        setRowFactory {
            TableRow<GameProjectEntity?>().apply {
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

        column("#", GameProjectEntity::idProperty)
        column(messages["name"], GameProjectEntity::nameProperty)
        column(messages["description"], GameProjectEntity::descriptionProperty)
        column(messages["documentation"], GameProjectEntity::documentationProperty) {
            converter(GameProjectDocumentationStringConverter)
        }

        itemModel.rebindOnChange(this) { selected ->
            item = selected ?: GameProjectEntity()
        }
    }

    fun onEdit() {
        val view = GameProjectEditFragment(itemModel)
        workspace.dock(view)
    }

    override fun onRefresh() {
        super.onRefresh()
        workspace.root.runAsyncWithOverlay(op = model::updateAll)
    }

    override fun onCreate() {
        super.onCreate()
        val view = GameProjectCreateFragment()
        workspace.dock(view)
    }

    override fun onDelete() {
        super.onDelete()
        when (val item = root.selectedItem) {
            null -> {
                val dialog = OkDialog(messages["item_not_selected"])
                workspace.openInternalWindow(dialog, movable = false, closeButton = false)
            }
            else -> {
                val title = messages["delete_game_project"]
                val text = messages["are_you_sure"]
                val confirmDialog = ConfirmDialog(title, text) { model.delete(item) }
                workspace.openInternalWindow(confirmDialog, movable = false, closeButton = false)
            }
        }
    }
}
