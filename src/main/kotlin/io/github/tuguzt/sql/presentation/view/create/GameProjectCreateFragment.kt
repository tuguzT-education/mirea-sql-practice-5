package io.github.tuguzt.sql.presentation.view.create

import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectDocumentationTableModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectTableModel
import io.github.tuguzt.sql.repository.model.GameProjectEntity
import tornadofx.*

class GameProjectCreateFragment : Fragment(FX.messages["create_game_project"]) {
    private val tableModel: GameProjectTableModel by inject()
    private val documentationTableModel: GameProjectDocumentationTableModel by inject()
    private val itemModel = GameProjectModel(GameProjectEntity())

    override val refreshable = itemModel.dirty
    override val savable = itemModel.dirty and itemModel.valid
    override val deletable = booleanProperty()
    override val creatable = booleanProperty()

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
                    combobox(itemModel.documentation, values = documentationTableModel.entities).required()
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
