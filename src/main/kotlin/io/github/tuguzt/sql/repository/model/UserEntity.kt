package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.User
import tornadofx.*
import javax.json.JsonObject

class UserEntity(
    login: String = "",
    passwordEncrypted: String = "",
    officer: OfficerEntity? = null,
    id: Int = 0,
) : User, JsonModel, ReadonlyIdEntity<Int>(id) {
    override var login: String by property(login)
    val loginProperty get() = getProperty(UserEntity::login)

    override var passwordEncrypted: String by property(passwordEncrypted)
    val passwordEncryptedProperty get() = getProperty(UserEntity::passwordEncrypted)

    override var officer: OfficerEntity? by property(officer)
    val officerProperty get() = getProperty(UserEntity::officer)

    override fun updateModel(json: JsonObject) = with(json) {
        _id = requireNotNull(int("id"))
        login = requireNotNull(string("login"))
        officer = jsonModel("officer")
        passwordEncrypted = requireNotNull(string("password_encrypted"))
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("id", id)
        add("login", login)
        add("officer", officer)
        add("password_encrypted", passwordEncrypted)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserEntity
        return id == other.id
    }

    override fun hashCode() = id
}
