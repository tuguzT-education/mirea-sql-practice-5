package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.empty
import io.github.tuguzt.sql.presentation.view.create.GameProjectDocumentationCreateFragment
import io.github.tuguzt.sql.presentation.view.dialog.ConfirmDialog
import io.github.tuguzt.sql.presentation.view.dialog.OkDialog
import io.github.tuguzt.sql.presentation.view.edit.GameAssetTypeEditFragment
import io.github.tuguzt.sql.presentation.view.edit.GameProjectDocumentationEditFragment
import io.github.tuguzt.sql.presentation.view.show.GameProjectDocumentationShowFragment
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectDocumentationModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectDocumentationTableModel
import io.github.tuguzt.sql.repository.model.GameProjectDocumentationEntity
import javafx.scene.control.TableRow
import tornadofx.*

class GameProjectDocumentationTableView :
    EntityTableView<GameProjectDocumentationEntity>(FX.messages["game_project_documentations"]) {

    override val model: GameProjectDocumentationTableModel by inject()
    override val itemModel = GameProjectDocumentationModel(GameProjectDocumentationEntity())

    override val createFragmentFactory = ::GameProjectDocumentationCreateFragment
    override val editFragmentFactory = { GameProjectDocumentationEditFragment(itemModel) }

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
}
