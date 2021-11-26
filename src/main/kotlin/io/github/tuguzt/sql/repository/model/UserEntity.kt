package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.User

class UserEntity(
    override val login: String,
    override val officer: OfficerEntity?,
    override val passwordEncrypted: String,
) : User
