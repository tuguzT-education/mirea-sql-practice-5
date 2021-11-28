package io.github.tuguzt.sql.presentation.viewmodel

import io.github.tuguzt.sql.repository.model.GameProjectDocumentationEntity
import javafx.beans.property.Property
import tornadofx.*

class GameProjectDocumentationModel(gameProjectDocumentation: GameProjectDocumentationEntity) :
    ItemViewModel<GameProjectDocumentationEntity>(gameProjectDocumentation) {
    val businessPlan: Property<String> = bind(GameProjectDocumentationEntity::businessPlanProperty)
    val designDocument: Property<String> = bind(GameProjectDocumentationEntity::designDocumentProperty)
    val vision: Property<String> = bind(GameProjectDocumentationEntity::visionProperty)
}
