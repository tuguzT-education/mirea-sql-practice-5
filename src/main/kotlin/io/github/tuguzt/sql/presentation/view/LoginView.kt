package io.github.tuguzt.sql.presentation.view

import io.github.tuguzt.sql.presentation.view.dialog.OkDialog
import io.github.tuguzt.sql.presentation.viewmodel.LoginViewModel
import io.github.tuguzt.sql.setupAuth
import javafx.geometry.Pos.CENTER
import tornadofx.*

/**
 * Login [view][View] of the application.
 */
class LoginView : View("${FX.messages["login"]} - ${FX.messages["app_name"]}") {
    private val model: LoginViewModel by inject()

    override val root = vbox(alignment = CENTER) {
        gridpane {
            alignment = CENTER
            row {
                form {
                    gridpaneColumnConstraints {
                        isFillWidth = true
                        percentWidth = 80.0
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
                            action {
                                this@vbox.runAsyncWithOverlay {
                                    model.submit()
                                } ui {
                                    app.setupAuth()
                                    find(AppWorkspace::class).dock<MainView>()
                                    replaceWith<AppWorkspace>()
                                } fail {
                                    openInternalWindow(
                                        OkDialog(messages["wrong_credentials_provided"]),
                                        closeButton = false,
                                        movable = false,
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        hbox(alignment = CENTER) {
            label(messages["no_account"])
            hyperlink(messages["register"]).action {
                replaceWith<RegisterView>(ViewTransition.Slide(0.2.seconds))
            }
        }
    }
}
