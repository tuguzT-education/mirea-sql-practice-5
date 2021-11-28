package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.MutableProperty
import io.github.tuguzt.sql.repository.model.*
import tornadofx.*

class OrganizationModel(organization: OrganizationEntity) : ItemViewModel<OrganizationEntity>(organization) {
    val name: MutableProperty<String> = bind(OrganizationEntity::nameProperty)
    val description: MutableProperty<String> = bind(OrganizationEntity::descriptionProperty)
    val type: MutableProperty<OrganizationTypeEntity> = bind(OrganizationEntity::typeProperty)
    val testDocument: MutableProperty<TestDocumentEntity?> = bind(OrganizationEntity::testDocumentProperty)
    val gameProjects: MutableProperty<Set<GameProjectEntity>> = bind(OrganizationEntity::gameProjectsProperty)
    val officers: MutableProperty<Set<OfficerEntity>> = bind(OrganizationEntity::officersProperty)
}
