package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.User
import tornadofx.JsonBuilder
import tornadofx.JsonModel
import tornadofx.jsonModel
import tornadofx.string
import javax.json.JsonObject

class UserEntity(
    override var login: String,
    override var passwordEncrypted: String,
    override var officer: OfficerEntity?,
) : User, JsonModel {
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
