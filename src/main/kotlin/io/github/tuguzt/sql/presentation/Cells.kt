package io.github.tuguzt.sql.presentation

import javafx.beans.property.ReadOnlyBooleanProperty
import javafx.scene.control.Cell

inline val <T> Cell<T>.empty: ReadOnlyBooleanProperty get() = emptyProperty()
