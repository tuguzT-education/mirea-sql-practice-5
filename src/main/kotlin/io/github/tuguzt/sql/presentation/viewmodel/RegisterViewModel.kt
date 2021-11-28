package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.presentation.view.RegisterView
import tornadofx.*

/**
 * [View model][ViewModel] subclass of the [register view][RegisterView].
 */
class RegisterViewModel : ViewModel() {
    private val api: Rest by inject()

    var name: String by property("")
    inline val nameProperty get() = getProperty(RegisterViewModel::name)

    var username: String by property("")
    inline val usernameProperty get() = getProperty(RegisterViewModel::username)

    var password: String by property("")
    inline val passwordProperty get() = getProperty(RegisterViewModel::password)

    var role: String by property("")
    inline val roleProperty get() = getProperty(RegisterViewModel::role)

    var organization: String by property("")
    inline val organizationProperty get() = getProperty(RegisterViewModel::organization)

    fun submit() {
        val name = name.trim()
        val role = role.trim()
        val organization = organization.trim()
        val username = username.trim()
        val password = password
        println("name: '$name', role: '$role', organization: '$organization', username: '$username', password: '$password'")
        TODO("submit register is not implemented")
    }
}
