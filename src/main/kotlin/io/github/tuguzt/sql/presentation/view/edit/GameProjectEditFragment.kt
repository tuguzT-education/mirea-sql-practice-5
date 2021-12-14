package io.github.tuguzt.sql.presentation.view.edit

import io.github.tuguzt.sql.presentation.view.converter.GameProjectDocumentationStringConverter
import io.github.tuguzt.sql.presentation.viewmodel.edit.GameProjectEditModel
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectDocumentationTableModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectTableModel
import io.github.tuguzt.sql.repository.model.GameProjectEntity
import tornadofx.*

class GameProjectEditFragment(override val itemModel: GameProjectModel) :
    EntityEditFragment<GameProjectEntity>(FX.messages["edit_game_project"]) {

    override val model: GameProjectEditModel by inject()
    override val tableModel: GameProjectTableModel by inject()

    private val documentationTableModel: GameProjectDocumentationTableModel by inject()

    override val root = scrollpane(fitToWidth = true, fitToHeight = true) {
        form {
            fieldset {
                field("#") {
                    label(itemModel.item.id.toString())
                }
                field(messages["name"]) {
                    textfield(itemModel.name).required()
                }
                field(messages["description"]) {
                    textarea(itemModel.description).required()
                }
                field(messages["documentation"]) {
                    combobox(itemModel.documentation, values = documentationTableModel.entities) {
                        converter = GameProjectDocumentationStringConverter
                        required()
                    }
                }
            }
        }
    }
}
