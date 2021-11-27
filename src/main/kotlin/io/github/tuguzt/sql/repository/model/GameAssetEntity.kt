package io.github.tuguzt.sql.repository.model

import io.github.tuguzt.sql.domain.model.GameAsset
import tornadofx.*
import javax.json.JsonObject

class GameAssetEntity(
    name: String = "",
    description: String = "",
    dataUri: String = "",
    type: GameAssetTypeEntity = GameAssetTypeEntity(),
) : GameAsset, JsonModel {

    override var dataUri: String by property(dataUri)
    val dataUriProperty get() = getProperty(GameAssetEntity::dataUri)

    override var description: String by property(description)
    inline val descriptionProperty get() = getProperty(GameAssetEntity::description)

    override var name: String by property(name)
    inline val nameProperty get() = getProperty(GameAssetEntity::name)

    override var type: GameAssetTypeEntity by property(type)
    inline val typeProperty get() = getProperty(GameAssetEntity::type)

    override fun updateModel(json: JsonObject) = with(json) {
        dataUri = requireNotNull(string("data_uri"))
        description = requireNotNull(string("description"))
        name = requireNotNull(string("name"))
        type = requireNotNull(jsonModel("type"))
    }

    override fun toJSON(json: JsonBuilder): Unit = with(json) {
        add("data_uri", dataUri)
        add("description", description)
        add("name", name)
        add("type", type)
    }
}
