package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.User
import tornadofx.*
import javax.json.JsonObject

class UserEntity(
    login: String = "",
    passwordEncrypted: String = "",
    officer: OfficerEntity? = null,
) : User, JsonModel {
    override var login: String by property(login)
    inline val loginProperty get() = getProperty(UserEntity::login)

    override var passwordEncrypted: String by property(passwordEncrypted)
    inline val passwordEncryptedProperty get() = getProperty(UserEntity::passwordEncrypted)

    override var officer: OfficerEntity? by property(officer)
    inline val officerProperty get() = getProperty(UserEntity::officer)

    override fun updateModel(json: JsonObject) = with(json) {
        login = requireNotNull(string("login"))
        officer = requireNotNull(jsonModel("officer"))
        passwordEncrypted = requireNotNull(string("passwordEncrypted"))
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("login", login)
        add("officer", officer)
        add("passwordEncrypted", passwordEncrypted)
    }
}
