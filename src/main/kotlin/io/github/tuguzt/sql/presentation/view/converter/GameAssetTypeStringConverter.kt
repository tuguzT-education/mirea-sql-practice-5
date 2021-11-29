package io.github.tuguzt.sql.presentation.view.converter

import io.github.tuguzt.sql.repository.model.GameAssetTypeEntity
import javafx.util.StringConverter

object GameAssetTypeStringConverter : StringConverter<GameAssetTypeEntity?>() {
    override fun toString(entity: GameAssetTypeEntity?) = entity?.name.orEmpty()

    override fun fromString(string: String?) = TODO("unknown id")
}
