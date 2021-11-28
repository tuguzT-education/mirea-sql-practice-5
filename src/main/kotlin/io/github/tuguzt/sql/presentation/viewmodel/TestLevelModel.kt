package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.MutableProperty
import io.github.tuguzt.sql.repository.model.TestLevelEntity
import tornadofx.*

class TestLevelModel(testLevel: TestLevelEntity) : ItemViewModel<TestLevelEntity>(testLevel) {
    val name: MutableProperty<String> = bind(TestLevelEntity::nameProperty)
}
