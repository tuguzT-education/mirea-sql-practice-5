package io.github.tuguzt.sql

import io.github.tuguzt.sql.presentation.view.RegisterView
import javafx.stage.Stage
import tornadofx.*

const val appName = "SQL Practice 5"

class Application : App(RegisterView::class) {
    override fun start(stage: Stage) {
        super.start(stage)
        with(stage) {
            minWidth = 300.0
            minHeight = 150.0
        }
    }
}

fun main(args: Array<String>) {
    launch<Application>(args)
}
