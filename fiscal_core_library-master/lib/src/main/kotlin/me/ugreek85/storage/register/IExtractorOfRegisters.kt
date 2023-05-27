package me.ugreek85.storage.register

import java.io.File

interface IExtractorOfRegisters {

    fun fromDocument(file: File): Map<String, Double>
}