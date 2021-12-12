package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.presentation.view.RegisterView
import io.github.tuguzt.sql.repository.model.UserEntity
import io.github.tuguzt.sql.userAccessToken
import tornadofx.*

/**
 * [View model][ViewModel] subclass of the [register view][RegisterView].
 */
class RegisterViewModel : ViewModel() {
    private val api: Rest by inject()

    var username: String by property("")
    val usernameProperty get() = getProperty(RegisterViewModel::username)

    var password: String by property("")
    val passwordProperty get() = getProperty(RegisterViewModel::password)

    fun submit() {
        val username = username.trim()
        val password = password
        val token = api.post("register", UserEntity(username, password)).text()
        app.userAccessToken = token
    }
}
