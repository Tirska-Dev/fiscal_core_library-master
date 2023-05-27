package me.ugreek85.storage.common

import me.ugreek85.extentions.mkdirIfNotExists
import java.io.File
import java.util.regex.Pattern

interface IDataStorage {

    fun <T> load(file: File, clazz: Class<T>): T
    fun <T> save(file: File, entity: T)

    fun getWorkingDirectory(): File

    fun getRootPathForRegistrar(registrarId: Long, createIfNotExists: Boolean = false): File
    {
        return File(getWorkingDirectory(), registrarId.toString()).apply{
            if(createIfNotExists) mkdirIfNotExists()
        }
    }

    fun getRootPathForShift(registrarId: Long, shiftId: String, createIfNotExists: Boolean = false): File
    {
        return File(getRootPathForRegistrar(registrarId, createIfNotExists), shiftId).apply{
            if(createIfNotExists) mkdirIfNotExists()
        }
    }

    fun getRootPathForIndex(registrarId: Long, createIfNotExists: Boolean = false): File
    {
        return File(getRootPathForRegistrar(registrarId, createIfNotExists), "index").apply{
            if(createIfNotExists) mkdirIfNotExists()
        }
    }

    fun getRootPathForDocuments(registrarId: Long, createIfNotExists: Boolean = false): File
    {
        return File(getRootPathForRegistrar(registrarId, createIfNotExists), "documents").apply{
            if(createIfNotExists) mkdirIfNotExists()
        }
    }

    fun getRootPathForOfflineDocuments(registrarId: Long, createIfNotExists: Boolean = false): File
    {
        return File(getRootPathForRegistrar(registrarId, createIfNotExists), "offline-documents").apply{
            if(createIfNotExists) mkdirIfNotExists()
        }
    }

    fun getRootPathForTaxRates(createIfNotExists: Boolean = false): File
    {
        return File(getWorkingDirectory(), "tax-rates").apply{
            if(createIfNotExists) mkdirIfNotExists()
        }
    }

    fun getRootPathForPayForms(createIfNotExists: Boolean = false): File
    {
        return File(getWorkingDirectory(), "pay-forms").apply{
            if(createIfNotExists) mkdirIfNotExists()
        }
    }

    fun getRootPathForShiftIndex(registrarId: Long, createIfNotExists: Boolean = false): File
    {
        return File(getRootPathForIndex(registrarId, true), "shifts").apply{
            if(createIfNotExists) mkdirIfNotExists()
        }
    }

    fun getRootPathForFiscalNumberIndex(registrarId: Long, createIfNotExists: Boolean = false): File
    {
        return File(getRootPathForIndex(registrarId, createIfNotExists), "fn").apply {
            if(createIfNotExists) mkdirIfNotExists()
        }
    }

    fun getRootPathForLocalNumberIndex(registrarId: Long, createIfNotExists: Boolean = false): File
    {
        return File(getRootPathForIndex(registrarId, createIfNotExists), "fn").apply {
            if(createIfNotExists) mkdirIfNotExists()
        }
    }

    private fun shiftIdRegexValidator() = Pattern.compile("\\d+|(\\d+\\.\\d+\\.\\d+)")

    private fun isValidShiftId(shiftId: String): Boolean {
        return shiftIdRegexValidator().matcher(shiftId).matches()
    }

    fun getUnorderedShiftPathList(registrarId: Long): Array<File>
    {
        return getRootPathForRegistrar(registrarId).listFiles { file -> file.isDirectory && isValidShiftId(file.name) } ?: emptyArray()
    }

    fun searchShift(shifts: Array<File>, shiftId: String): File?
    {
        if(shifts.isEmpty())  return null
        return shifts.find { it.name == shiftId }
    }

    private fun localDocumentRegexValidator() = Pattern.compile("\\d+")

    private fun isValidLocalNumber(localNumber: String): Boolean
    {
        return localDocumentRegexValidator().matcher(localNumber).matches()
    }

    fun getDocumentPathList(documentsDirectory: File): Array<File>
    {
        return documentsDirectory.listFiles { file -> file.isFile && isValidLocalNumber(file.name) } ?: emptyArray()
    }
}