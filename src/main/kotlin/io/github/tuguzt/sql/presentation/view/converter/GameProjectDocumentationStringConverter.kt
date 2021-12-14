package io.github.tuguzt.sql.presentation.view.converter

import io.github.tuguzt.sql.repository.model.GameProjectDocumentationEntity
import javafx.util.StringConverter
import tornadofx.*

object GameProjectDocumentationStringConverter : StringConverter<GameProjectDocumentationEntity?>() {
    override fun toString(entity: GameProjectDocumentationEntity?) =
        "${FX.messages["documentation"]} #${entity?.id?.toString().orEmpty()}"

    override fun fromString(string: String?) = TODO("unknown id")
}
