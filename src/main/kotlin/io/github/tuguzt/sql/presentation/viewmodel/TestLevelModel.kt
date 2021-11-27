package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.repository.model.TestLevelEntity
import javafx.beans.property.Property
import tornadofx.ItemViewModel

class TestLevelModel(testLevel: TestLevelEntity) : ItemViewModel<TestLevelEntity>(testLevel) {
    val name: Property<String> = bind(TestLevelEntity::nameProperty)
}
