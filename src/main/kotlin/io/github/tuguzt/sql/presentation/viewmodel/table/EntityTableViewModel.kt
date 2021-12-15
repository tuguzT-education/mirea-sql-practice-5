package io.github.tuguzt.sql.presentation.viewmodel.table

import tornadofx.*
import javax.json.JsonArray
import javax.json.JsonObject
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

sealed class EntityTableViewModel<T : JsonModel> : ViewModel() {
    protected abstract val kClass: KClass<out T>
    protected abstract val pathName: String

    @Suppress("MemberVisibilityCanBePrivate")
    protected val api: Rest by inject()

    val entities = observableListOf<T>()

    init {
        runAsync { updateAll() }
    }

    fun updateAll() {
        val result = api.get("$pathName/all").list().toModel(kClass)
        runLater {
            handleResult(result)
            entities.setAll(result)
        }
    }

    open fun handleResult(result: List<T>) = Unit

    fun save(entity: T): T {
        val result = api.post("$pathName/save", entity).one().toModel(kClass)
        when (result) {
            in entities -> {
                val index = entities.indexOf(result)
                require(index != -1)
                entities[index] = result
            }
            else -> entities += result
        }
        runLater {
            handleResult(listOf(result))
        }
        return result
    }

    fun delete(entity: T) {
        api.delete("$pathName/delete", entity)
        entities -= entity
    }
}

fun <T : JsonModel> JsonArray.toModel(kClass: KClass<T>) =
    observableListOf(map { (it as JsonObject).toModel(kClass) })

fun <T : JsonModel> JsonObject.toModel(kClass: KClass<T>): T =
    kClass.createInstance().apply { updateModel(this@toModel) }
