package io.github.tuguzt.sql.presentation.view.edit

import io.github.tuguzt.sql.presentation.viewmodel.edit.GameAssetTypeEditModel
import io.github.tuguzt.sql.presentation.viewmodel.item.GameAssetTypeModel
import tornadofx.*

class GameAssetTypeEditFragment(private val typeModel: GameAssetTypeModel) :
    Fragment(FX.messages["edit_game_asset_type"]) {

    private val model: GameAssetTypeEditModel by inject()

    override val root = form {
        fieldset {
            field(messages["name"]) {
                textfield(typeModel.name).required()
            }
            buttonbar {
                button(messages["submit"]) {
                    enableWhen {
                        (typeModel.dirty and typeModel.valid) or (model.dirty and model.valid)
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
        typeModel.commit()
        close()
    }

    private fun cancel() {
        typeModel.rollback()
        close()
    }
}
