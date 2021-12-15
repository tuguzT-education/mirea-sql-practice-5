package io.github.tuguzt.sql.presentation.view

import javafx.geometry.Pos.CENTER
import tornadofx.*

/**
 * Main [view][View] of the application.
 */
class MainView : View(FX.messages["app_name"]) {
    override val deletable = booleanProperty()
    override val creatable = booleanProperty()
    override val refreshable = booleanProperty()
    override val savable = booleanProperty()

    override val root = vbox(spacing = 8, alignment = CENTER) {
        button(messages["data_management"]).action {
            workspace.dock<DataManagementView>()
        }
        button(messages["user_page"]).action {
            workspace.dock<UserView>()
        }
    }
}
