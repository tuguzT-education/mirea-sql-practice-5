package io.github.tuguzt.sql.presentation.view

import io.github.tuguzt.sql.repository.model.ReadonlyIdEntity
import javafx.scene.control.ComboBox
import tornadofx.*

inline fun <reified T : ReadonlyIdEntity<Int>> ComboBox<T>.entityRequired() = validator {
    if (it == null || it.id == 0) error(viewModelBundle["required"]) else null
}
