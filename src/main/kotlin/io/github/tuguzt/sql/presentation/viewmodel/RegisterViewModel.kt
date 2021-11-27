package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.presentation.view.RegisterView
import tornadofx.ViewModel
import tornadofx.getProperty
import tornadofx.property

/**
 * [View model][ViewModel] subclass of the [register view][RegisterView].
 */
class RegisterViewModel : ViewModel() {
    /**
     * Property for name text field.
     */
    val nameProperty get() = getProperty(RegisterViewModel::name)
    var name: String by property("")

    /**
     * Property for username text field.
     */
    val usernameProperty get() = getProperty(RegisterViewModel::username)
    var username: String by property("")

    /**
     * Property for password text field.
     */
    val passwordProperty get() = getProperty(RegisterViewModel::password)
    var password: String by property("")

    /**
     * Property for role combobox.
     */
    val roleProperty get() = getProperty(RegisterViewModel::role)
    var role: String by property("")

    /**
     * Property for organization combobox.
     */
    val organizationProperty get() = getProperty(RegisterViewModel::organization)
    var organization: String by property("")

    /**
     * Submits given [name], [username], [password], [role] and [organization].
     */
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
