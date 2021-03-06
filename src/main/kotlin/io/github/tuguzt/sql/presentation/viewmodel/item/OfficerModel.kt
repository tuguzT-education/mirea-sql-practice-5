package io.github.tuguzt.sql.presentation.viewmodel.item

import io.github.tuguzt.sql.MutableProperty
import io.github.tuguzt.sql.repository.model.OfficerEntity
import io.github.tuguzt.sql.repository.model.OfficerRoleEntity
import io.github.tuguzt.sql.repository.model.OrganizationEntity
import tornadofx.*

class OfficerModel(officer: OfficerEntity) : ItemViewModel<OfficerEntity>(officer) {
    val name: MutableProperty<String> = bind(OfficerEntity::nameProperty)
    val role: MutableProperty<OfficerRoleEntity> = bind(OfficerEntity::roleProperty)
    val organization: MutableProperty<OrganizationEntity> = bind(OfficerEntity::organizationProperty)
}
