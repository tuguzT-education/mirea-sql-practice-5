package io.github.tuguzt.sql.presentation.view

import io.github.tuguzt.sql.presentation.view.table.GameAssetTypeTableView
import io.github.tuguzt.sql.presentation.view.table.GameProjectDocumentationTableView
import io.github.tuguzt.sql.presentation.view.table.GameProjectPlatformTableView
import io.github.tuguzt.sql.presentation.view.table.GameProjectTableView
import tornadofx.*

/**
 * Main [view][View] of the application.
 */
class MainView : View(FX.messages["app_name"]) {
    override val root = tabpane {
        tab<GameAssetTypeTableView>()
        tab<GameProjectDocumentationTableView>()
        tab<GameProjectPlatformTableView>()
        tab<GameProjectTableView>()
        connectWorkspaceActions()
    }
}
