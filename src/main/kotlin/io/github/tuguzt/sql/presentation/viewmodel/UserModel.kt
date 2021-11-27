package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.repository.model.OfficerEntity
import io.github.tuguzt.sql.repository.model.UserEntity
import javafx.beans.property.Property
import tornadofx.ItemViewModel

class UserModel(user: UserEntity) : ItemViewModel<UserEntity>(user) {
    val login: Property<String> = bind(UserEntity::loginProperty)
    val passwordEncrypted: Property<String> = bind(UserEntity::passwordEncryptedProperty)
    val officer: Property<OfficerEntity?> = bind(UserEntity::officerProperty)
}
