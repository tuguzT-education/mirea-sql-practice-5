package io.github.tuguzt.sql.presentation.view.edit

import io.github.tuguzt.sql.presentation.viewmodel.edit.GameAssetTypeEditModel
import io.github.tuguzt.sql.presentation.viewmodel.item.GameAssetTypeModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameAssetTypeTableModel
import tornadofx.*

class GameAssetTypeEditFragment(private val itemModel: GameAssetTypeModel) :
    Fragment(FX.messages["edit_game_asset_type"]) {

    private val model: GameAssetTypeEditModel by inject()
    private val tableModel: GameAssetTypeTableModel by inject()

    override val root = form {
        fieldset {
            field(messages["name"]) {
                textfield(itemModel.name).required()
            }
            buttonbar {
                button(messages["submit"]) {
                    enableWhen {
                        (itemModel.dirty and itemModel.valid) or (model.dirty and model.valid)
                    }
                    action(::submit)
                }
                button(messages["cancel"]) {
                    action(::cancel)
                }
            }
        }
    }

    private fun submit() {
        root.runAsyncWithOverlay {
            itemModel.commit()
            tableModel.save(itemModel.item)
        } ui {
            close()
        }
    }

    private fun cancel() {
        itemModel.rollback()
        close()
    }
}
