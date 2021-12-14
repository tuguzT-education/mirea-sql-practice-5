package io.github.tuguzt.sql.presentation.view.edit

import io.github.tuguzt.sql.presentation.viewmodel.edit.GameAssetTypeEditModel
import io.github.tuguzt.sql.presentation.viewmodel.item.GameAssetTypeModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameAssetTypeTableModel
import tornadofx.*

class GameAssetTypeEditFragment(private val itemModel: GameAssetTypeModel) :
    Fragment(FX.messages["edit_game_asset_type"]) {

    private val model: GameAssetTypeEditModel by inject()
    private val tableModel: GameAssetTypeTableModel by inject()

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
