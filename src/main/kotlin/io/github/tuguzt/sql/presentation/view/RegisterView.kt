package io.github.tuguzt.sql.presentation.view

import io.github.tuguzt.sql.appName
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import tornadofx.*

class RegisterView : View("Register - $appName") {
    private val nameProperty = SimpleStringProperty()
    private var name: String? by nameProperty

    private val usernameProperty = SimpleStringProperty()
    private var username: String? by usernameProperty

    private val passwordProperty = SimpleStringProperty()
    private var password: String? by passwordProperty

    private val roleProperty = SimpleStringProperty()
    private var role: String? by roleProperty

    private val organizationProperty = SimpleStringProperty()
    private var organization: String? by organizationProperty

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
                            textfield(nameProperty)
                        }
                        field("Role") {
                            val roles = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                            val combobox = combobox(roleProperty, roles)
                            button("Clear").action {
                                combobox.selectionModel.clearSelection()
                            }
                        }
                        field("Organization") {
                            val organizations = listOf("Hello", "World")
                            val combobox = combobox(organizationProperty, organizations)
                            button("Clear").action {
                                combobox.selectionModel.clearSelection()
                            }
                        }
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
            label("Already have account? ")
            hyperlink("Login").action {
                replaceWith(LoginView::class)
            }
        }
    }

    private fun submit() {
        val name = name.orEmpty()
        val role = role.orEmpty()
        val organization = organization.orEmpty()
        val username = username.orEmpty()
        val password = password.orEmpty()
        println("name: '$name', role: '$role', organization: '$organization', " +
                "username: '$username', password: '$password'")
        TODO("submit register is not implemented")
    }
}
