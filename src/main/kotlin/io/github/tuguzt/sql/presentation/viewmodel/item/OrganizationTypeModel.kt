package io.github.tuguzt.sql.presentation.viewmodel.item

import io.github.tuguzt.sql.MutableProperty
import io.github.tuguzt.sql.repository.model.OrganizationTypeEntity
import tornadofx.*

class OrganizationTypeModel(organizationType: OrganizationTypeEntity) :
    ItemViewModel<OrganizationTypeEntity>(organizationType) {
    val name: MutableProperty<String> = bind(OrganizationTypeEntity::nameProperty)
}
