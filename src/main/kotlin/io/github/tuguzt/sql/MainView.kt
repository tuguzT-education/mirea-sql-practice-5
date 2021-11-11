package io.github.tuguzt.sql

import tornadofx.*

class MainView : View() {
    override val root = vbox {
        button("Press me")
        label("Waiting")
    }
}
