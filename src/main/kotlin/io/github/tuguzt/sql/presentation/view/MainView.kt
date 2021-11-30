package io.github.tuguzt.sql.presentation.view

import io.github.tuguzt.sql.presentation.view.table.*
import javafx.geometry.Side
import tornadofx.*

/**
 * Main [view][View] of the application.
 */
class MainView : View(FX.messages["app_name"]) {
    override val root = drawer(side = Side.TOP) {
        item<GameAssetTableView>()
        item<GameAssetTypeTableView>()
        item<GameProjectDocumentationTableView>()
        item<GameProjectPlatformTableView>()
        item<GameProjectVersionTableView>()
        item<GameProjectTableView>()
    }
}
