package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.repository.model.OfficerEntity
import io.github.tuguzt.sql.repository.model.OfficerRoleEntity
import javafx.beans.property.Property
import tornadofx.ItemViewModel

class OfficerModel(officer: OfficerEntity) : ItemViewModel<OfficerEntity>(officer) {
    val name: Property<String> = bind(OfficerEntity::nameProperty)
    val role: Property<OfficerRoleEntity> = bind(OfficerEntity::roleProperty)
}
