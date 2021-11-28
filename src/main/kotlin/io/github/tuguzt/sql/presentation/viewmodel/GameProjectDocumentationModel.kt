package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.MutableProperty
import io.github.tuguzt.sql.repository.model.GameProjectDocumentationEntity
import tornadofx.*

class GameProjectDocumentationModel(gameProjectDocumentation: GameProjectDocumentationEntity) :
    ItemViewModel<GameProjectDocumentationEntity>(gameProjectDocumentation) {
    val businessPlan: MutableProperty<String> = bind(GameProjectDocumentationEntity::businessPlanProperty)
    val designDocument: MutableProperty<String> = bind(GameProjectDocumentationEntity::designDocumentProperty)
    val vision: MutableProperty<String> = bind(GameProjectDocumentationEntity::visionProperty)
}
