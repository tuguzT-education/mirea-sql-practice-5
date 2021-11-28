package io.github.tuguzt.sql.presentation.viewmodel.item

import io.github.tuguzt.sql.MutableProperty
import io.github.tuguzt.sql.repository.model.TestDocumentEntity
import io.github.tuguzt.sql.repository.model.TestLevelEntity
import tornadofx.*

class TestDocumentModel(testDocument: TestDocumentEntity) : ItemViewModel<TestDocumentEntity>(testDocument) {
    val data: MutableProperty<String> = bind(TestDocumentEntity::dataProperty)
    val level: MutableProperty<TestLevelEntity> = bind(TestDocumentEntity::levelProperty)
}
