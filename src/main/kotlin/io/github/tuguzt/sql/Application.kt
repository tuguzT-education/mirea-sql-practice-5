package io.github.tuguzt.sql

import io.github.tuguzt.sql.presentation.view.AppWorkspace
import javafx.stage.Stage
import tornadofx.*

/**
 * Main class of the application.
 */
class Application : App(AppWorkspace::class) {
    private val api: Rest by inject()

    init {
        api.baseURI = "https://tuguzt-sql-practice-5.herokuapp.com"
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
