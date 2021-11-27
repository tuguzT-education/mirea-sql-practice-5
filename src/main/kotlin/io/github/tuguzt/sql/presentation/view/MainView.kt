package io.github.tuguzt.sql.presentation.view

import tornadofx.FX
import tornadofx.View
import tornadofx.borderpane
import tornadofx.get

/**
 * Main [view][View] of the application.
 */
class MainView : View(FX.messages["app_name"]) {
    override val root = borderpane {
        center<GameAssetTableFragment>()
    }
}
