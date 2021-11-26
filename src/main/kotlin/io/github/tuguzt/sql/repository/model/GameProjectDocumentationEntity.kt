package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.GameProjectDocumentation

class GameProjectDocumentationEntity(
    override val businessPlan: String,
    override val designDocument: String,
    override val vision: String,
) : GameProjectDocumentation
