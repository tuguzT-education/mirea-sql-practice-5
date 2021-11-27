package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.presentation.view.LoginView
import tornadofx.Rest
import tornadofx.ViewModel
import tornadofx.getProperty
import tornadofx.property

/**
 * [View model][ViewModel] subclass of the [login view][LoginView].
 */
class LoginViewModel : ViewModel() {
    private val api: Rest by inject()

    /**
     * Property for username text field.
     */
    val usernameProperty get() = getProperty(LoginViewModel::username)
    var username: String by property("")

    /**
     * Property for password text field.
     */
    val passwordProperty get() = getProperty(LoginViewModel::password)
    var password: String by property("")

    /**
     * Submits given [username] and [password].
     */
    fun submit() {
        val username = username.trim()
        val password = password
        println("username: '$username', password: '$password'")
        TODO("submit login is not implemented")
    }
}
