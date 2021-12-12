package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.presentation.view.LoginView
import io.github.tuguzt.sql.repository.model.UserEntity
import io.github.tuguzt.sql.userAccessToken
import tornadofx.*

/**
 * [View model][ViewModel] subclass of the [login view][LoginView].
 */
class LoginViewModel : ViewModel() {
    private val api: Rest by inject()

    var username: String by property("")
    val usernameProperty get() = getProperty(LoginViewModel::username)

    var password: String by property("")
    val passwordProperty get() = getProperty(LoginViewModel::password)

    fun submit() {
        val username = username.trim()
        val password = password
        val token = api.post("auth", UserEntity(username, password)).text()
        app.userAccessToken = token
    }
}
