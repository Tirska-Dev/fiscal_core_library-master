package me.ugreek85.storage.common

import java.io.File
import java.util.regex.Pattern

interface IDocumentAbility {

    private val localDocumentRegexValidator: Pattern
        get() = Pattern.compile("\\d+")

    private fun isValidLocalNumber(localNumber: String): Boolean
    {
        return localDocumentRegexValidator.matcher(localNumber).matches()
    }

    fun getDocuments(documentsDirectory: File): Array<File>
    {
        return documentsDirectory.listFiles { file -> file.isFile && isValidLocalNumber(file.name) } ?: emptyArray()
    }
}