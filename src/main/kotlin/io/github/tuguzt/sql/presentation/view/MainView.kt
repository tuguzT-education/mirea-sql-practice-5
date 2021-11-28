package io.github.tuguzt.sql.presentation.view

import io.github.tuguzt.sql.presentation.view.table.GameAssetTableView
import io.github.tuguzt.sql.presentation.view.table.GameAssetTypeTableView
import javafx.geometry.Pos
import tornadofx.*

/**
 * Main [view][View] of the application.
 */
class MainView : View(FX.messages["app_name"]) {
    override val root = vbox(spacing = 10, alignment = Pos.CENTER) {
        button(messages["game_assets"]) {
            action {
                replaceWith<GameAssetTableView>()
            }
        }
        button(messages["game_asset_types"]) {
            action {
                replaceWith<GameAssetTypeTableView>()
            }
        }
    }
}
