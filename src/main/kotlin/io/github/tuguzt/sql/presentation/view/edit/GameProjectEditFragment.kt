package io.github.tuguzt.sql.presentation.view.edit

import io.github.tuguzt.sql.presentation.view.converter.GameProjectDocumentationStringConverter
import io.github.tuguzt.sql.presentation.viewmodel.edit.GameProjectEditModel
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectDocumentationTableModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectTableModel
import tornadofx.*

class GameProjectEditFragment(private val itemModel: GameProjectModel) : Fragment(FX.messages["edit_game_project"]) {
    private val model: GameProjectEditModel by inject()
    private val tableModel: GameProjectTableModel by inject()
    private val documentationTableModel: GameProjectDocumentationTableModel by inject()

    override val refreshable = itemModel.dirty or model.dirty
    override val savable = (itemModel.dirty and itemModel.valid) or (model.dirty and model.valid)
    override val deletable = booleanProperty()
    override val creatable = booleanProperty()

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

    override fun onRefresh() {
        super.onRefresh()
        itemModel.rollback()
    }

    override fun onSave() {
        super.onSave()
        workspace.root.runAsyncWithOverlay {
            itemModel.commit()
            tableModel.save(itemModel.item)
        } ui {
            workspace.navigateBack()
            workspace.viewStack -= this
        }
    }
}
