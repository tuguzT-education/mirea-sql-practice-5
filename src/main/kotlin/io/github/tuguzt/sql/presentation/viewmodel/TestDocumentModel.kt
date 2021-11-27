package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.repository.model.TestDocumentEntity
import io.github.tuguzt.sql.repository.model.TestLevelEntity
import javafx.beans.property.Property
import tornadofx.ItemViewModel

class TestDocumentModel(testDocument: TestDocumentEntity) : ItemViewModel<TestDocumentEntity>(testDocument) {
    val data: Property<String> = bind(TestDocumentEntity::dataProperty)
    val level: Property<TestLevelEntity> = bind(TestDocumentEntity::levelProperty)
}
