package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.MutableProperty
import io.github.tuguzt.sql.repository.model.OfficerRoleEntity
import tornadofx.*

class OfficerRoleModel(officerRole: OfficerRoleEntity) : ItemViewModel<OfficerRoleEntity>(officerRole) {
    val name: MutableProperty<String> = bind(OfficerRoleEntity::nameProperty)
}
