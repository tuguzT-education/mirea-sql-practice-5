package io.github.tuguzt.sql.presentation.viewmodel.table

import io.github.tuguzt.sql.repository.model.GameAssetTypeEntity
import tornadofx.*

class GameAssetTypeTableModel : ViewModel() {
    private val api: Rest by inject()

    val assetTypes = api.get("game_asset_types/all").list().toModel<GameAssetTypeEntity>()
}
