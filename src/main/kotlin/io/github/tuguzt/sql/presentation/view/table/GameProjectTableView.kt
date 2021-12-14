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

class GameProjectTableView : EntityTableView<GameProjectEntity>(FX.messages["game_projects"]) {
    override val model: GameProjectTableModel by inject()
    override val itemModel = GameProjectModel(GameProjectEntity())

    override val createFragmentFactory = { GameProjectCreateFragment() }
    override val editFragmentFactory = { GameProjectEditFragment(itemModel) }

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
}
