package io.github.tuguzt.sql.presentation.view.create

import io.github.tuguzt.sql.presentation.viewmodel.item.GameProjectPlatformModel
import io.github.tuguzt.sql.presentation.viewmodel.table.GameProjectPlatformTableModel
import io.github.tuguzt.sql.repository.model.GameProjectPlatformEntity
import tornadofx.*

class GameProjectPlatformCreateFragment : Fragment(FX.messages["create_game_project_platform"]) {
    private val tableModel: GameProjectPlatformTableModel by inject()
    private val itemModel = GameProjectPlatformModel(GameProjectPlatformEntity())

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
