package io.github.tuguzt.sql.presentation.view

import io.github.tuguzt.sql.presentation.view.table.GameAssetTableView
import io.github.tuguzt.sql.presentation.view.table.GameAssetTypeTableView
import io.github.tuguzt.sql.presentation.view.table.GameProjectDocumentationTableView
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
    }
}
