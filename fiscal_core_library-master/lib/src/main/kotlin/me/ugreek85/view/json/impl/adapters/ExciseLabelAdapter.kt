package me.ugreek85.view.json.impl.adapters

import com.google.gson.*
import me.ugreek85.document.common.DocumentType
import me.ugreek85.view.json.impl.receipt.JsonExciseLabel
import java.lang.reflect.Type

class ExciseLabelAdapter : JsonSerializer<JsonExciseLabel>, JsonDeserializer<JsonExciseLabel> {

    override fun serialize(src: JsonExciseLabel, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        return JsonPrimitive(src.getLabel())
    }

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): JsonExciseLabel {
        val jsonPrimitive = (json as JsonPrimitive)
        return JsonExciseLabel().apply {
            setLabel(jsonPrimitive.asString)
        }
    }
}