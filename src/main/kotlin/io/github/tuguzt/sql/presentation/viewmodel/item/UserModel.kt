package io.github.tuguzt.sql.presentation.viewmodel.item

import io.github.tuguzt.sql.MutableProperty
import io.github.tuguzt.sql.repository.model.OfficerEntity
import io.github.tuguzt.sql.repository.model.UserEntity
import tornadofx.*

class UserModel(user: UserEntity) : ItemViewModel<UserEntity>(user) {
    val login: MutableProperty<String> = bind(UserEntity::loginProperty)
    val passwordEncrypted: MutableProperty<String> = bind(UserEntity::passwordEncryptedProperty)
    val officer: MutableProperty<OfficerEntity?> = bind(UserEntity::officerProperty)
}
