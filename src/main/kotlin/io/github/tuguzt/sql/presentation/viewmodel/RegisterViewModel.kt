package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.presentation.view.RegisterView
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

/**
 * [View model][ViewModel] subclass of the [register view][RegisterView].
 */
class RegisterViewModel : ViewModel() {
    /**
     * Property for name text field.
     */
    val nameProperty = bind { SimpleStringProperty() }
    val name: String? by nameProperty

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
     * Property for role combobox.
     */
    val roleProperty = bind { SimpleStringProperty() }
    val role: String? by roleProperty

    /**
     * Property for organization combobox.
     */
    val organizationProperty = bind { SimpleStringProperty() }
    val organization: String? by organizationProperty

    /**
     * Submits given [name], [username], [password], [role] and [organization].
     */
    fun submit() {
        val name = name.orEmpty()
        val role = role.orEmpty()
        val organization = organization.orEmpty()
        val username = username.orEmpty()
        val password = password.orEmpty()
        println(
            "name: '$name', role: '$role', organization: '$organization', " +
                    "username: '$username', password: '$password'"
        )
        TODO("submit register is not implemented")
    }
}
