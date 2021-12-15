package io.github.tuguzt.sql.presentation.view.create

import io.github.tuguzt.sql.presentation.view.converter.GameProjectStringConverter
import io.github.tuguzt.sql.presentation.view.entityRequired
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectVersionModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectTableModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectVersionTableModel
import io.github.tuguzt.sql.repository.model.GameProjectVersionEntity
import tornadofx.*

class GameProjectVersionCreateFragment :
    EntityCreateFragment<GameProjectVersionEntity>(FX.messages["create_game_project_version"]) {

    override val tableModel: GameProjectVersionTableModel by inject()
    override val itemModel = GameProjectVersionModel(GameProjectVersionEntity())

    private val gameProjectTableModel: GameProjectTableModel by inject()

    override val root = scrollpane(fitToWidth = true, fitToHeight = true) {
        form {
            fieldset {
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
                    textfield(itemModel.metadata).required()
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
}
