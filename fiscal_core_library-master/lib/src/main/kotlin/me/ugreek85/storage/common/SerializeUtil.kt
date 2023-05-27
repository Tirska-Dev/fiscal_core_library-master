package me.ugreek85.storage.common

import com.google.gson.GsonBuilder
import java.io.File
import java.lang.reflect.Type
import java.nio.file.Files
import java.text.DateFormat


object SerializeUtil {

    val gson = GsonBuilder()
        .setPrettyPrinting()
        .setDateFormat(DateFormat.MEDIUM, DateFormat.MEDIUM)
        .create()

    fun <T> serialize(entity: T): ByteArray
    {
        return gson.toJson(entity).toByteArray(Charsets.UTF_8)
    }

    fun <T> save(file: File, entity: T)
    {
        Files.write(file.toPath(), serialize(entity))
    }

    inline fun <reified T> deserialize(bytes: ByteArray): T
    {
        return gson.fromJson(String(bytes, Charsets.UTF_8), T::class.java)
    }

    inline fun <reified T> load(file: File): T
    {
        return deserialize(Files.readAllBytes(file.toPath()))
    }
}