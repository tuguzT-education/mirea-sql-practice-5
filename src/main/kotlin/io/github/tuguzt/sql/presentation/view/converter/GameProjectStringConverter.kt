package io.github.tuguzt.sql.presentation.view.converter

import io.github.tuguzt.sql.repository.model.GameProjectEntity
import javafx.util.StringConverter
import tornadofx.FX
import tornadofx.get

object GameProjectStringConverter : StringConverter<GameProjectEntity?>() {
    override fun toString(entity: GameProjectEntity?) =
        if (entity == null || entity.id == 0) "" else "${FX.messages["game_project"]} #${entity.id}"

    override fun fromString(string: String?) = TODO("unknown id")
}
