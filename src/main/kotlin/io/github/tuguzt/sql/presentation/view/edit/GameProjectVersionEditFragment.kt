package io.github.tuguzt.sql.presentation.view.edit

import io.github.tuguzt.sql.presentation.view.converter.GameProjectStringConverter
import io.github.tuguzt.sql.presentation.view.entityRequired
import io.github.tuguzt.sql.presentation.viewmodel.edit.GameProjectVersionEditModel
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectVersionModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectTableModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectVersionTableModel
import io.github.tuguzt.sql.repository.model.GameProjectVersionEntity
import tornadofx.*

class GameProjectVersionEditFragment(override val itemModel: GameProjectVersionModel) :
    EntityEditFragment<GameProjectVersionEntity>(FX.messages["edit_game_project_version"]) {

    override val model: GameProjectVersionEditModel by inject()
    override val tableModel: GameProjectVersionTableModel by inject()

    private val gameProjectTableModel: GameProjectTableModel by inject()

    override val root = form {
        fieldset {
            field("#") {
                label(itemModel.item.id.toString())
            }
            field(messages["hash"]) {
                textfield(itemModel.hash).required()
            }
            field(messages["major"]) {
                textfield(itemModel.major).required()
            }
            field(messages["minor"]) {
                textfield(itemModel.minor).required()
            }
            field(messages["patch"]) {
                textfield(itemModel.patch).required()
            }
            field(messages["metadata"]) {
                textfield(itemModel.metadata)
            }
            field(messages["game_project"]) {
                combobox(itemModel.gameProject, values = gameProjectTableModel.entities) {
                    converter = GameProjectStringConverter
                    entityRequired()
                }
            }
        }
    }
}
