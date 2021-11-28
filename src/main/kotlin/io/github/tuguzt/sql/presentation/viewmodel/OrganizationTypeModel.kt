package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.repository.model.OrganizationTypeEntity
import javafx.beans.property.Property
import tornadofx.*

class OrganizationTypeModel(organizationType: OrganizationTypeEntity) :
    ItemViewModel<OrganizationTypeEntity>(organizationType) {
    val name: Property<String> = bind(OrganizationTypeEntity::nameProperty)
}
