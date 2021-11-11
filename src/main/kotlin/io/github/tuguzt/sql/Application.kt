package io.github.tuguzt.sql

import javafx.stage.Stage
import tornadofx.*

class Application : App(MainView::class) {
    override fun start(stage: Stage) {
        with(stage) {
            minWidth = 300.0
            minHeight = 150.0
        }
        super.start(stage)
    }
}

fun main(args: Array<String>) {
    launch<Application>(args)
}
