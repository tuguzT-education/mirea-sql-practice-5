package io.github.tuguzt.sql.presentation.view.create

import io.github.tuguzt.sql.presentation.viewmodel.item.GameAssetTypeModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameAssetTypeTableModel
import io.github.tuguzt.sql.repository.model.GameAssetTypeEntity
import tornadofx.*

class GameAssetTypeCreateFragment : Fragment(FX.messages["create_game_asset_type"]) {
    private val tableModel: GameAssetTypeTableModel by inject()
    private val typeModel = GameAssetTypeModel(GameAssetTypeEntity())

    override val root = form {
        fieldset {
            field(messages["name"]) {
                textfield(typeModel.name).required()
            }
            buttonbar {
                button(messages["submit"]) {
                    enableWhen { typeModel.dirty and typeModel.valid }
                    action(::submit)
                }
                button(messages["cancel"]) {
                    action(::close)
                }
            }
        }
    }

    private fun submit() {
        root.runAsyncWithOverlay {
            typeModel.commit()
            tableModel.save(typeModel.item)
        } ui {
            typeModel.item = it
            close()
        }
    }
}