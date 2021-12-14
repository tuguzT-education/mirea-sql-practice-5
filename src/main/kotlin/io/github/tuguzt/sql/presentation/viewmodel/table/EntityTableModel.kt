package io.github.tuguzt.sql.presentation.viewmodel.table

import tornadofx.*
import javax.json.JsonObject
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

sealed class EntityTableModel<T : JsonModel>(
    private val kClass: KClass<out T>,
    private val pathName: String,
) : ViewModel() {
    @Suppress("MemberVisibilityCanBePrivate")
    protected val api: Rest by inject()

    val entities = observableListOf<T>()

    init {
        runAsync { updateAll() }
    }

    fun updateAll() {
        val result = api.get("$pathName/all").list().map {
            kClass.createInstance().apply { updateModel(it as JsonObject) }
        }
        entities.setAll(result)
    }

    fun save(entity: T): T {
        val jsonObject = api.post("$pathName/save", entity).one()
        val result = kClass.createInstance().apply { updateModel(jsonObject) }
        when (result) {
            in entities -> {
                val index = entities.indexOf(result)
                require(index != -1)
                entities[index] = result
            }
            else -> entities += result
        }
        return result
    }

    fun delete(entity: T) {
        api.delete("$pathName/delete", entity)
        entities -= entity
    }
}
