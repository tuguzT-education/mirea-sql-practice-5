package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.Officer

class OfficerEntity(override val name: String, override val role: OfficerRoleEntity) : Officer
