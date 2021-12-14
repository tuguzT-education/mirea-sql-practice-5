package io.github.tuguzt.sql.presentation.view.dialog

import tornadofx.*

class OkDialog(title: String) : Fragment() {
    override val root = form {
        fieldset {
            label(title)
        }
        buttonbar {
            button(messages["ok"]) {
                action(::close)
                shortcut("Enter")
            }
        }
    }
}
