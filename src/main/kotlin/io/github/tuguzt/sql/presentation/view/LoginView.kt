package io.github.tuguzt.sql.presentation.view

import io.github.tuguzt.sql.appName
import io.github.tuguzt.sql.presentation.viewmodel.LoginViewModel
import javafx.geometry.Pos
import tornadofx.*

/**
 * Login [view][View] of the application.
 */
class LoginView : View("Login - $appName") {
    private val model: LoginViewModel by inject()

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
                            textfield(model.usernameProperty).required()
                        }
                        field("Password") {
                            passwordfield(model.passwordProperty).required()
                        }
                    }
                    buttonbar {
                        button("Submit") {
                            enableWhen(model.valid)
                            action(model::submit)
                        }
                    }
                }
            }
        }
        hbox {
            alignment = Pos.CENTER
            label("No account? ")
            hyperlink("Register").action {
                replaceWith<RegisterView>(ViewTransition.Slide(0.2.seconds))
            }
        }
    }
}
