package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.presentation.view.LoginView
import tornadofx.*

/**
 * [View model][ViewModel] subclass of the [login view][LoginView].
 */
class LoginViewModel : ViewModel() {
    private val api: Rest by inject()

    var username: String by property("")
    inline val usernameProperty get() = getProperty(LoginViewModel::username)

    var password: String by property("")
    inline val passwordProperty get() = getProperty(LoginViewModel::password)

    fun submit() {
        val username = username.trim()
        val password = password
        println("username: '$username', password: '$password'")
        TODO("submit login is not implemented")
    }
}
