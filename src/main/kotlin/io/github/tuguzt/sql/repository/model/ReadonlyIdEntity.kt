package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.ObjectProperty
import io.github.tuguzt.sql.domain.model.Identifiable
import tornadofx.getProperty
import tornadofx.property

abstract class ReadonlyIdEntity<T : Any>(id: T) : Identifiable<T> {
    protected var _id: T by property(id)
    override val id get() = _id

    protected val _idProperty get() = getProperty(ReadonlyIdEntity<T>::_id)
    val idProperty: ObjectProperty<T> get() = _idProperty
}
