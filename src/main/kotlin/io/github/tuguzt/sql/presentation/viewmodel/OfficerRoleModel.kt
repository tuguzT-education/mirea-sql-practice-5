package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.repository.model.OfficerRoleEntity
import javafx.beans.property.Property
import tornadofx.ItemViewModel

class OfficerRoleModel(officerRole: OfficerRoleEntity) : ItemViewModel<OfficerRoleEntity>(officerRole) {
    val name: Property<String> = bind(OfficerRoleEntity::nameProperty)
}
