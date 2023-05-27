package me.ugreek85.storage.common

import me.ugreek85.extentions.mkdirIfNotExists
import java.io.File

abstract class PathAbility(
    @Transient private val workingDirectory: File
) {

    fun getWorkingDirectory() = workingDirectory

    fun getRootPathForRegistrar(registrarId: Long, createIfNotExists: Boolean = false): File
    {
        return File(workingDirectory, registrarId.toString()).apply{
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
        return File(workingDirectory, "tax-rates").apply{
            if(createIfNotExists) mkdirIfNotExists()
        }
    }

    fun getRootPathForPayForms(createIfNotExists: Boolean = false): File
    {
        return File(workingDirectory, "pay-forms").apply{
            if(createIfNotExists) mkdirIfNotExists()
        }
    }

    fun getRootPathForShiftsIndexes(registrarId: Long, createIfNotExists: Boolean = false): File
    {
        return File(getRootPathForIndex(registrarId, true), "shifts").apply{
            if(createIfNotExists) mkdirIfNotExists()
        }
    }
}