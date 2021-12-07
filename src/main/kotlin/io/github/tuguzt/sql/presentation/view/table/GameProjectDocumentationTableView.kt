package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.empty
import io.github.tuguzt.sql.presentation.view.create.GameProjectDocumentationCreateFragment
import io.github.tuguzt.sql.presentation.view.dialog.ConfirmDialog
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

    override val root = borderpane {
        top = hbox(spacing = 8) {
            button(messages["refresh"]).action(::refresh)
            button(messages["add"]).action {
                openInternalWindow(GameProjectDocumentationCreateFragment(), movable = false, closeButton = false)
            }
        }
        center = tableview(model.entities) {
            isEditable = true
            setRowFactory {
                TableRow<GameProjectDocumentationEntity?>().apply {
                    fun editItem() {
                        val view = GameProjectDocumentationEditFragment(itemModel)
                        openInternalWindow(view, movable = false, closeButton = false)
                    }

                    fun showItem() {
                        openInternalWindow(GameProjectDocumentationShowFragment(itemModel), movable = false)
                    }

                    fun removeItem() {
                        val title = messages["delete_game_project_documentation"]
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

            column("#", GameProjectDocumentationEntity::idProperty)
            column(messages["business_plan"], GameProjectDocumentationEntity::businessPlanProperty)
            column(messages["design_document"], GameProjectDocumentationEntity::designDocumentProperty)
            column(messages["vision"], GameProjectDocumentationEntity::visionProperty)

            itemModel.rebindOnChange(this) { selected ->
                item = selected ?: GameProjectDocumentationEntity()
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
