package io.github.tuguzt.sql

import io.github.tuguzt.sql.presentation.view.MainView
import io.github.tuguzt.sql.presentation.view.RegisterView
import javafx.stage.Stage
import tornadofx.App
import tornadofx.Rest
import tornadofx.launch

/**
 * Main class of the application.
 */
class Application : App() {
    private val api: Rest by inject()

    init {
        api.baseURI = "https://tuguzt-sql-practice-5.herokuapp.com"
    }

    override val primaryView = kotlin.run {
        val userKey = config["user_key"]?.toString()
        val isUserFound = !userKey.isNullOrBlank()
        if (isUserFound) MainView::class else RegisterView::class
    }

    override fun start(stage: Stage) {
        super.start(stage)
        with(stage) {
            minWidth = 300.0
            minHeight = 150.0
        }
    }
}

/**
 * Entry point of the application.
 */
fun main(args: Array<String>) {
    launch<Application>(args)
}
