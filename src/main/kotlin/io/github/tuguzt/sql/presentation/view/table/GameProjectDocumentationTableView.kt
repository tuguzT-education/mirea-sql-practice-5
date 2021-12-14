package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.empty
import io.github.tuguzt.sql.presentation.view.create.GameProjectDocumentationCreateFragment
import io.github.tuguzt.sql.presentation.view.dialog.ConfirmDialog
import io.github.tuguzt.sql.presentation.view.dialog.OkDialog
import io.github.tuguzt.sql.presentation.view.edit.GameProjectDocumentationEditFragment
import io.github.tuguzt.sql.presentation.view.show.GameProjectDocumentationShowFragment
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectDocumentationModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectDocumentationTableModel
import io.github.tuguzt.sql.repository.model.GameProjectDocumentationEntity
import javafx.scene.control.TableRow
import tornadofx.*

class GameProjectDocumentationTableView : View(FX.messages["game_project_documentations"]) {
    private val model: GameProjectDocumentationTableModel by inject()
    private val itemModel = GameProjectDocumentationModel(GameProjectDocumentationEntity())

    override val savable = booleanProperty()

    override val root = tableview(model.entities) {
        isEditable = true
        setRowFactory {
            TableRow<GameProjectDocumentationEntity?>().apply {
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

        column("#", GameProjectDocumentationEntity::idProperty)
        column(messages["business_plan"], GameProjectDocumentationEntity::businessPlanProperty)
        column(messages["design_document"], GameProjectDocumentationEntity::designDocumentProperty)
        column(messages["vision"], GameProjectDocumentationEntity::visionProperty)

        itemModel.rebindOnChange(this) { selected ->
            item = selected ?: GameProjectDocumentationEntity()
        }
    }

    fun onEdit() {
        val view = GameProjectDocumentationEditFragment(itemModel)
        workspace.dock(view)
    }

    override fun onRefresh() {
        super.onRefresh()
        workspace.root.runAsyncWithOverlay(op = model::updateAll)
    }

    override fun onCreate() {
        super.onCreate()
        val view = GameProjectDocumentationCreateFragment()
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
                val title = messages["delete_game_project_documentation"]
                val text = messages["are_you_sure"]
                val confirmDialog = ConfirmDialog(title, text) { model.delete(item) }
                workspace.openInternalWindow(confirmDialog, movable = false, closeButton = false)
            }
        }
    }
}
