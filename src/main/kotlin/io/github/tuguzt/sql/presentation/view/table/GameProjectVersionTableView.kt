package io.github.tuguzt.sql.presentation.view.table

import io.github.tuguzt.sql.presentation.empty
import io.github.tuguzt.sql.presentation.view.converter.GameProjectStringConverter
import io.github.tuguzt.sql.presentation.view.create.EntityCreateFragment
import io.github.tuguzt.sql.presentation.view.create.GameProjectVersionCreateFragment
import io.github.tuguzt.sql.presentation.view.edit.EntityEditFragment
import io.github.tuguzt.sql.presentation.view.edit.GameProjectVersionEditFragment
import io.github.tuguzt.sql.presentation.view.show.GameProjectVersionShowFragment
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectVersionModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectTableModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectVersionTableModel
import io.github.tuguzt.sql.repository.model.GameProjectVersionEntity
import javafx.scene.control.TableRow
import tornadofx.*

class GameProjectVersionTableView : EntityTableView<GameProjectVersionEntity>(FX.messages["game_project_versions"]) {
    override val model: GameProjectVersionTableModel by inject()
    override val itemModel = GameProjectVersionModel(GameProjectVersionEntity())

    override val createFragmentFactory = { GameProjectVersionCreateFragment() }
    override val editFragmentFactory = { GameProjectVersionEditFragment(itemModel) }

    private val gameProjectTableModel: GameProjectTableModel by inject()

    override val root = tableview(model.entities) {
        isEditable = true
        setRowFactory {
            TableRow<GameProjectVersionEntity?>().apply {
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

        column("#", GameProjectVersionEntity::idProperty)
        column(messages["hash"], GameProjectVersionEntity::hashProperty)
        column(messages["major"], GameProjectVersionEntity::majorProperty)
        column(messages["minor"], GameProjectVersionEntity::minorProperty)
        column(messages["patch"], GameProjectVersionEntity::patchProperty)
        column(messages["metadata"], GameProjectVersionEntity::metadataProperty)
        column(messages["game_project"], GameProjectVersionEntity::gameProjectProperty) {
            converter(GameProjectStringConverter)
        }

        itemModel.rebindOnChange(this) { selected ->
            item = selected ?: GameProjectVersionEntity()
        }
    }
}
