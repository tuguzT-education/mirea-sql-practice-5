package io.github.tuguzt.sql.presentation.view.converter

import io.github.tuguzt.sql.repository.model.GameProjectDocumentationEntity
import javafx.util.StringConverter
import tornadofx.*

object GameProjectDocumentationStringConverter : StringConverter<GameProjectDocumentationEntity?>() {
    override fun toString(entity: GameProjectDocumentationEntity?) =
        if (entity == null || entity.id == 0) "" else "${FX.messages["documentation"]} #${entity.id}"

    override fun fromString(string: String?) = TODO("unknown id")
}
