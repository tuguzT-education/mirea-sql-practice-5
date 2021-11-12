package io.github.tuguzt.sql.presentation.view

import io.github.tuguzt.sql.appName
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import tornadofx.*

class LoginView : View("Login - $appName") {
    private val usernameProperty = SimpleStringProperty()
    private var username: String? by usernameProperty

    private val passwordProperty = SimpleStringProperty()
    private var password: String? by passwordProperty

    override val root = vbox {
        alignment = Pos.CENTER
        gridpane {
            alignment = Pos.CENTER
            row {
                form {
                    gridpaneColumnConstraints {
                        isFillWidth = true
                        percentWidth = 80.0
                    }
                    fieldset("User information") {
                        field("Username") {
                            textfield(usernameProperty)
                        }
                        field("Password") {
                            passwordfield(passwordProperty)
                        }
                    }
                    buttonbar {
                        button("Submit").action(::submit)
                    }
                }
            }
        }
        hbox {
            alignment = Pos.CENTER
            label("No account? ")
            hyperlink("Register").action {
                replaceWith(RegisterView::class)
            }
        }
    }

    private fun submit() {
        val username = username.orEmpty()
        val password = password.orEmpty()
        println("username: '$username', password: '$password'")
        TODO("submit login is not implemented")
    }
}
