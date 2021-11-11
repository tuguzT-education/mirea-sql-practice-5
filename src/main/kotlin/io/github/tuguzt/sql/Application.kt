package io.github.tuguzt.sql

import tornadofx.*

class Application : App(MainView::class)

fun main(args: Array<String>) {
    launch<Application>(args)
}
