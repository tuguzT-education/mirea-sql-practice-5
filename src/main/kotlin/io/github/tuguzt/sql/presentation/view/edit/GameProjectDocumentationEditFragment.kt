package io.github.tuguzt.sql.presentation.view.edit

import io.github.tuguzt.sql.presentation.viewmodel.edit.GameProjectDocumentationEditModel
import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectDocumentationModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectDocumentationTableModel
import tornadofx.*

class GameProjectDocumentationEditFragment(private val itemModel: GameProjectDocumentationModel) :
    Fragment(FX.messages["edit_game_project_documentation"]) {

    private val model: GameProjectDocumentationEditModel by inject()
    private val tableModel: GameProjectDocumentationTableModel by inject()

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
                field(messages["business_plan"]) {
                    textarea(itemModel.businessPlan).required()
                }
                field(messages["design_document"]) {
                    textarea(itemModel.designDocument).required()
                }
                field(messages["vision"]) {
                    textarea(itemModel.vision).required()
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
