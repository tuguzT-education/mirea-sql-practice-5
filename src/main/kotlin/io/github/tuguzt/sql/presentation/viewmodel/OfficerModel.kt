package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.MutableProperty
import io.github.tuguzt.sql.repository.model.OfficerEntity
import io.github.tuguzt.sql.repository.model.OfficerRoleEntity
import tornadofx.*

class OfficerModel(officer: OfficerEntity) : ItemViewModel<OfficerEntity>(officer) {
    val name: MutableProperty<String> = bind(OfficerEntity::nameProperty)
    val role: MutableProperty<OfficerRoleEntity> = bind(OfficerEntity::roleProperty)
}
