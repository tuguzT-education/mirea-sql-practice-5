package io.github.tuguzt.sql

import javafx.beans.property.ObjectProperty
import javafx.beans.property.Property
import javafx.beans.property.ReadOnlyObjectProperty
import javafx.beans.property.ReadOnlyProperty

typealias Property<T> = ReadOnlyProperty<T>
typealias MutableProperty<T> = Property<T>

typealias ObjectProperty<T> = ReadOnlyObjectProperty<T>
typealias MutableObjectProperty<T> = ObjectProperty<T>
