package io.github.tuguzt.sql.presentation.view.dialog

import tornadofx.*

class ConfirmDialog(title: String, text: String, action: () -> Unit) : Fragment(title) {
    override val root = form {
        fieldset {
            field {
                label(text)
            }
            buttonbar {
                button(messages["yes"]).action {
                    this@form.runAsyncWithOverlay {
                        action()
                    }.ui {
                        close()
                    }
                }
                button(messages["no"]).action(::close)
            }
        }
    }
}
