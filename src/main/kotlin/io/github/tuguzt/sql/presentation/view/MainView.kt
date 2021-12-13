package io.github.tuguzt.sql.presentation.view

import io.github.tuguzt.sql.presentation.view.table.*
import io.github.tuguzt.sql.userAccessToken
import javafx.geometry.Side
import tornadofx.*

/**
 * Main [view][View] of the application.
 */
class MainView : View(FX.messages["app_name"]) {
    private val api: Rest by inject()

    init {
        with(api.engine) {
            requestInterceptor = { request ->
                request.addHeader("Authorization", "Bearer ${app.userAccessToken}")
            }
            responseInterceptor = { response ->
                if (response.statusCode == 401 || response.statusCode == 403) {
                    app.userAccessToken = null
                    requestInterceptor = null
                    responseInterceptor = null
                    replaceWith<LoginView>()
                }
            }
        }
    }

    override val root = drawer(side = Side.TOP) {
        item<GameAssetTableView>()
        item<GameAssetTypeTableView>()
        item<GameProjectDocumentationTableView>()
        item<GameProjectPlatformTableView>()
        item<GameProjectVersionTableView>()
        item<GameProjectTableView>()
    }
}
