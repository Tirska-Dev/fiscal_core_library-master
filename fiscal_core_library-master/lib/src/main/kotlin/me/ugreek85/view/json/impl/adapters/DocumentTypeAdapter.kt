package me.ugreek85.view.json.impl.adapters

import com.google.gson.*
import me.ugreek85.document.common.DocumentType
import java.lang.reflect.Type

class DocumentTypeAdapter : JsonSerializer<DocumentType>, JsonDeserializer<DocumentType> {

    override fun serialize(src: DocumentType, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        return JsonPrimitive(src.value[0].lowercaseChar() + src.value.substring(1))
    }

    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): DocumentType {
        val jsonPrimitive = (json as JsonPrimitive)
        val value = jsonPrimitive.asString[0].uppercaseChar()  + jsonPrimitive.asString.substring(1)
        return DocumentType.values().asSequence().find { documentType ->  documentType.value == value }
            ?: throw EnumConstantNotPresentException(DocumentType::class.java, value)
    }
}