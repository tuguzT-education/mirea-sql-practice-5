package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.presentation.view.LoginView
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

/**
 * [View model][ViewModel] subclass of the [login view][LoginView].
 */
class LoginViewModel : ViewModel() {
    /**
     * Property for username text field.
     */
    val usernameProperty = bind { SimpleStringProperty() }
    val username: String? by usernameProperty

    /**
     * Property for password text field.
     */
    val passwordProperty = bind { SimpleStringProperty() }
    val password: String? by passwordProperty

    /**
     * Submits given [username] and [password].
     */
    fun submit() {
        val username = username.orEmpty()
        val password = password.orEmpty()
        println("username: '$username', password: '$password'")
        TODO("submit login is not implemented")
    }
}
