package me.ugreek85.view.json.impl.util

import com.google.gson.GsonBuilder
import me.ugreek85.document.common.DocumentType
import me.ugreek85.view.json.impl.adapters.DocumentTypeAdapter
import me.ugreek85.view.json.impl.adapters.ExciseLabelAdapter
import me.ugreek85.view.json.impl.receipt.JsonExciseLabel

object JsonMapperUtil {

    private val mapper = GsonBuilder()
        .registerTypeAdapter(DocumentType::class.java, DocumentTypeAdapter())
        .registerTypeAdapter(JsonExciseLabel::class.java, ExciseLabelAdapter())
        .setPrettyPrinting()
        .create()

    fun toJSON(source: Any): String{
        return mapper.toJson(source)
    }

    fun <T> fromJSON(type: Class<T>, source: String): T
    {
        return mapper.fromJson(source, type)
    }

//    fun toJSON(source: Any, output: OutputStream) {
//
//        mapper.toJson(source).let { json->
//            output.write(json.toByteArray(Charsets.UTF_8))
//        }
//    }
//
//    fun toJSON(source: Any, output: File) {
//        FileOutputStream(output).use {
//            toJSON(source, it)
//        }
//    }
//
//    fun <T> fromJSON(type: Class<T>, source: InputStream): T
//    {
//        return //XmlMapperUtil.serializer.read(type, source, false)
//
//        mapper.fromJson()
//    }
//
//    fun <T> fromJSON(type: Class<T>, source: File): T
//    {
//        FileInputStream(source).use {
//            return fromJSON(type, it)
//        }
//    }
}