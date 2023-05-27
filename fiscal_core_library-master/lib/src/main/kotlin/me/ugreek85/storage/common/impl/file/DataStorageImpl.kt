package me.ugreek85.storage.common.impl.file

import com.google.gson.GsonBuilder
import me.ugreek85.storage.common.IDataStorage
import java.io.File
import java.nio.file.Files
import java.text.DateFormat

class DataStorageImpl(
    @Transient private val workingDirectory: File
) : IDataStorage {

    val gson = GsonBuilder()
        .setPrettyPrinting()
        .setDateFormat(DateFormat.MEDIUM, DateFormat.MEDIUM)
        .create()

    override fun <T> load(file: File, clazz: Class<T>): T {
        return deserialize(Files.readAllBytes(file.toPath()), clazz)
    }

    override fun <T> save(file: File, entity: T) {
        Files.write(file.toPath(), serialize(entity))
    }

    private fun <T> serialize(entity: T): ByteArray {
        return gson.toJson(entity).toByteArray(Charsets.UTF_8)
    }

    private fun <T> deserialize(bytes: ByteArray, clazz: Class<T>): T {
        return gson.fromJson(String(bytes, Charsets.UTF_8), clazz)
    }

    override fun getWorkingDirectory(): File = workingDirectory
}