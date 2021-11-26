package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.Organization

class OrganizationEntity(
    override val description: String,
    override val gameProjects: Set<GameProjectEntity>,
    override val name: String,
    override val officers: Set<OfficerEntity>,
    override val testDocument: TestDocumentEntity?,
    override val type: OrganizationTypeEntity,
) : Organization
