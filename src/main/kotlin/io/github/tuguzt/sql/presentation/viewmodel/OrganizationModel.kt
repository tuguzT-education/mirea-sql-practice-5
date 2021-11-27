package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.repository.model.*
import javafx.beans.property.Property
import tornadofx.ItemViewModel

class OrganizationModel(organization: OrganizationEntity) : ItemViewModel<OrganizationEntity>(organization) {
    val name: Property<String> = bind(OrganizationEntity::nameProperty)
    val description: Property<String> = bind(OrganizationEntity::descriptionProperty)
    val type: Property<OrganizationTypeEntity> = bind(OrganizationEntity::typeProperty)
    val testDocument: Property<TestDocumentEntity?> = bind(OrganizationEntity::testDocumentProperty)
    val gameProjects: Property<Set<GameProjectEntity>> = bind(OrganizationEntity::gameProjectsProperty)
    val officers: Property<Set<OfficerEntity>> = bind(OrganizationEntity::officersProperty)
}
