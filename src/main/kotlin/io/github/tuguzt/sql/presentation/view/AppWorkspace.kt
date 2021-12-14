package io.github.tuguzt.sql.presentation.view

import io.github.tuguzt.sql.setupAuth
import io.github.tuguzt.sql.userAccessToken
import tornadofx.*

class AppWorkspace : Workspace(FX.messages["app_name"]) {
    init {
        app.setupAuth()
        defaultCloseable = false
    }

    override fun onBeforeShow() {
        if (app.userAccessToken.isNullOrBlank()) {
            replaceWith<LoginView>()
            return
        }
        dock<MainView>()
    }
}
