package me.ugreek85.storage.stored_document

import java.io.File

interface IStoredDocument {

    fun getFile(): File
    fun getSize(): Long
    fun getBytes(): ByteArray //Lazy loading
    fun getHash(): String
}