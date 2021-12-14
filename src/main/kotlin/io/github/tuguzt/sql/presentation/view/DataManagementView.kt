package io.github.tuguzt.sql.presentation.view

import io.github.tuguzt.sql.presentation.view.table.*
import tornadofx.*

class DataManagementView : View(FX.messages["data_management"]) {
    override val root = tabpane {
        tab<GameAssetTypeTableView>()
        tab<GameProjectDocumentationTableView>()
        tab<GameProjectPlatformTableView>()
        tab<GameProjectTableView>()
        connectWorkspaceActions()
    }
}
