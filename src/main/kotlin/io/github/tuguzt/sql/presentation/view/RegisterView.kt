package io.github.tuguzt.sql.presentation.view

import io.github.tuguzt.sql.presentation.viewmodel.RegisterViewModel
import javafx.geometry.Pos
import tornadofx.*

/**
 * Register [view][View] of the application.
 */
class RegisterView : View("${FX.messages["register"]} - ${FX.messages["app_name"]}") {
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
                    fieldset(messages["officer_information"]) {
                        field(messages["name"]) {
                            textfield(model.nameProperty).required()
                        }
                        field(messages["role"]) {
                            val roles = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                            val combobox = combobox(model.roleProperty, roles)
                            button(messages["clear"]) {
                                enableWhen { !model.roleProperty.isEmpty }
                                action {
                                    combobox.selectionModel.clearSelection()
                                }
                            }
                        }
                        field(messages["organization"]) {
                            val organizations = listOf("Hello", "World")
                            val combobox = combobox(model.organizationProperty, organizations)
                            button(messages["clear"]) {
                                enableWhen { !model.organizationProperty.isEmpty }
                                action {
                                    combobox.selectionModel.clearSelection()
                                }
                            }
                        }
                    }
                    fieldset(messages["user_information"]) {
                        field(messages["username"]) {
                            textfield(model.usernameProperty).required()
                        }
                        field(messages["password"]) {
                            passwordfield(model.passwordProperty).required()
                        }
                    }
                    buttonbar {
                        button(messages["submit"]) {
                            enableWhen(model.valid)
                            action(model::submit)
                        }
                    }
                }
            }
        }
        hbox {
            alignment = Pos.CENTER
            label(messages["already_have_account"])
            hyperlink(messages["login"]).action {
                replaceWith<LoginView>(ViewTransition.Slide(0.2.seconds))
            }
        }
    }
}
