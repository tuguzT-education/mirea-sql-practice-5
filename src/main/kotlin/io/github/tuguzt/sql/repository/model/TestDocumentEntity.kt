package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.TestDocument

class TestDocumentEntity(override val data: String, override val level: TestLevelEntity) : TestDocument
