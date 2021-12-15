package io.github.tuguzt.sql.presentation.view.create

import io.github.tuguzt.sql.presentation.view.converter.GameProjectDocumentationStringConverter
import io.github.tuguzt.sql.presentation.view.entityRequired
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectDocumentationTableModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectTableModel
import io.github.tuguzt.sql.repository.model.GameProjectEntity
import tornadofx.*

class GameProjectCreateFragment : EntityCreateFragment<GameProjectEntity>(FX.messages["create_game_project"]) {
    override val tableModel: GameProjectTableModel by inject()
    override val itemModel = GameProjectModel(GameProjectEntity())

    private val documentationTableModel: GameProjectDocumentationTableModel by inject()

    override val root = scrollpane(fitToWidth = true, fitToHeight = true) {
        form {
            fieldset {
                field(messages["name"]) {
                    textfield(itemModel.name).required()
                }
                field(messages["description"]) {
                    textarea(itemModel.description).required()
                }
                field(messages["documentation"]) {
                    combobox(itemModel.documentation, values = documentationTableModel.entities) {
                        converter = GameProjectDocumentationStringConverter
                        entityRequired()
                    }
                }
            }
        }
    }
}
