package io.github.tuguzt.sql.presentation.view

import io.github.tuguzt.sql.appName
import io.github.tuguzt.sql.presentation.viewmodel.RegisterViewModel
import javafx.geometry.Pos
import tornadofx.*

/**
 * Register [view][View] of the application.
 */
class RegisterView : View("Register - $appName") {
    private val model: RegisterViewModel by inject()

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
                    fieldset("Officer information") {
                        field("Name") {
                            textfield(model.nameProperty).required()
                        }
                        field("Role") {
                            val roles = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                            val combobox = combobox(model.roleProperty, roles)
                            button("Clear").action {
                                combobox.selectionModel.clearSelection()
                            }
                        }
                        field("Organization") {
                            val organizations = listOf("Hello", "World")
                            val combobox = combobox(model.organizationProperty, organizations)
                            button("Clear").action {
                                combobox.selectionModel.clearSelection()
                            }
                        }
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
            label("Already have account? ")
            hyperlink("Login").action {
                replaceWith<LoginView>(ViewTransition.Slide(0.2.seconds))
            }
        }
    }
}
