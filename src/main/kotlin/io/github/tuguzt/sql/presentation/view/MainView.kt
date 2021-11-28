package io.github.tuguzt.sql.presentation.view

import tornadofx.*

/**
 * Main [view][View] of the application.
 */
class MainView : View(FX.messages["app_name"]) {
    override val root = stackpane {
        button(messages["game_assets"]) {
            action {
                replaceWith<GameAssetTableView>()
            }
        }
    }
}
