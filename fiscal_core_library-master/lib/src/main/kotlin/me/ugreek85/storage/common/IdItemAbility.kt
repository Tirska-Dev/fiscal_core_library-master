package me.ugreek85.storage.common

import me.ugreek85.extentions.sortByName
import java.io.File
import java.nio.file.Files
import java.util.*
import java.util.regex.Pattern

abstract class IdItemAbility<T : IItemWithId>(
    private val rootDirectory: File,
    private val lock: Any
) {



    private val idRegexValidator = Pattern.compile("\\d+")

    private var nextId: Long = 1
    private val records = TreeMap<Long, T>()

    abstract fun loader(file: File): T

    protected fun load(loader: (file: File) -> T)
    {
        synchronized(lock) {

            val files = getFiles(rootDirectory).sortByName()
            files.forEach {
                records[it.name.toLong()] = loader(it)
            }
            nextId = getMaxId() + 1
        }
    }

    private fun getMaxId(): Long
    {
        if(records.isNotEmpty()) return records.lastKey()
        return 0
    }

    private fun getFiles(directory: File): Array<File>
    {
        return directory.listFiles { file -> file.isFile && isValidId(file.name) } ?: emptyArray()
    }

    private fun isValidId(id: String): Boolean
    {
        return idRegexValidator.matcher(id).matches()
    }

    private fun getPath(id: Long) = File(rootDirectory, id.toString())

    protected fun getNewId() = nextId++
    protected fun getRecords() = records
    protected fun containsKey(id: Long): Boolean = records.containsKey(id)
    protected fun put(id: Long, record: T) = records.put(id, record)
    protected fun get(id: Long) = records[id]
    protected fun remove(id: Long) = records.remove(id)

    protected fun addRecord(record: T): Long {

        synchronized(lock)
        {
            record.setId(getNewId())
            if(containsKey(record.getId())) return -1
            SerializeUtil.save(getPath(record.getId()), record)
            put(record.getId(), record)
            return record.getId()
        }
    }

    protected fun updateRecord(record: T): Boolean {

        synchronized(lock)
        {
            if(!containsKey(record.getId())) return false
            SerializeUtil.save(getPath(record.getId()), record)
            put(record.getId(), record)
            return true
        }
    }

    protected fun deleteRecord(id: Long): Boolean {

        synchronized(lock)
        {
            if(!containsKey(id)) return false
            Files.delete(getPath(id).toPath())
            remove(id)
            return true
        }
    }

    protected fun getRecord(id: Long): T? {
        synchronized(lock)
        {
            return get(id)
        }
    }

    protected fun search(filter: (record: T) -> Boolean): T? {
        synchronized(lock)
        {
            records.forEach { (_, it) ->
                if(filter(it)) return it
            }

            return null
        }
    }
}