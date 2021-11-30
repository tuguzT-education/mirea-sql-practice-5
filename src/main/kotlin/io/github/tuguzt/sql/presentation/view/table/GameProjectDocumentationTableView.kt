package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.empty
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

    override val root = tableview(model.documentations) {
        isEditable = true
        setRowFactory {
            TableRow<GameProjectDocumentationEntity?>().apply {
                fun editItem() {
                    openInternalWindow(
                        GameProjectDocumentationEditFragment(itemModel),
                        movable = false,
                        closeButton = false
                    )
                }

                fun showItem() {
                    openInternalWindow(GameProjectDocumentationShowFragment(itemModel), movable = false)
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

        column("#", GameProjectDocumentationEntity::idProperty)
        column(messages["business_plan"], GameProjectDocumentationEntity::businessPlanProperty)
        column(messages["design_document"], GameProjectDocumentationEntity::designDocumentProperty)
        column(messages["vision"], GameProjectDocumentationEntity::visionProperty)

        itemModel.rebindOnChange(this) { selected ->
            item = selected ?: GameProjectDocumentationEntity()
        }
    }
}
