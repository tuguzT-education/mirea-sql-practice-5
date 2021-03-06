package io.github.tuguzt.sql.presentation.view

import io.github.tuguzt.sql.presentation.view.dialog.OkDialog
import io.github.tuguzt.sql.presentation.viewmodel.RegisterViewModel
import io.github.tuguzt.sql.setupAuth
import javafx.geometry.Pos.CENTER
import tornadofx.*

/**
 * Register [view][View] of the application.
 */
class RegisterView : View("${FX.messages["register"]} - ${FX.messages["app_name"]}") {
    private val model: RegisterViewModel by inject()

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
            label(messages["already_have_account"])
            hyperlink(messages["login"]).action {
                replaceWith<LoginView>(ViewTransition.Slide(0.2.seconds))
            }
        }
    }
}
