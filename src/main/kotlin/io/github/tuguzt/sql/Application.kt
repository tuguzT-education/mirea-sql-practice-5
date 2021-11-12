package io.github.tuguzt.sql

import io.github.tuguzt.sql.presentation.view.MainView
import io.github.tuguzt.sql.presentation.view.RegisterView
import javafx.stage.Stage
import tornadofx.*

/**
 * Name of this application.
 */
const val appName = "SQL Practice 5"

/**
 * Main class of the application.
 */
class Application : App() {
    override val primaryView = kotlin.run {
        val isUserFound = false
        if (isUserFound) {
            MainView::class
        } else {
            RegisterView::class
        }
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
