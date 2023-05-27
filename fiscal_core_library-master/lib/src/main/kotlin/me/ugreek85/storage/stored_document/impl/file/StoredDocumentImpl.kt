package me.ugreek85.storage.stored_document.impl.file

import me.ugreek85.storage.stored_document.IStoredDocument
import me.ugreek85.extentions.toHex
import java.io.File
import java.security.DigestInputStream
import java.security.DigestOutputStream
import java.security.MessageDigest




class StoredDocumentImpl(
    private val file: File,
    private var bytes: ByteArray? = null
) : IStoredDocument {


    private var hash: String? = null


    override fun getFile(): File {
        return file
    }

    override fun getSize(): Long {
        return file.length()
    }

    override fun getBytes(): ByteArray {
        synchronized(this) {
            if (bytes == null) readFile()
            return bytes!!
        }
    }

    override fun getHash(): String {

        synchronized(this) {
            if (hash == null) readFile()
            return hash!!
        }
    }

    private fun readFile()
    {
        val maxChunkSize = 1024
        val buffer = ByteArray(file.length().toInt())
        var pos = 0
        var read = 0
        var chunk = Math.min(buffer.size, maxChunkSize)

        file.inputStream().use{ input ->
            DigestInputStream(input, getMessageDigest()).use {

                while (true) {
                    read = it.read(buffer, pos, chunk)

                    if (read == -1 || (chunk == 0 && read == 0)) {
                        bytes = buffer
                        hash = it.messageDigest.digest().toHex()
                        break
                    }

                    pos += read
                    chunk = Math.min(buffer.size - pos, maxChunkSize)
                }
            }
        }
    }

    private fun getMessageDigest(): MessageDigest? {
        return MessageDigest.getInstance("SHA-256")
    }

    fun writeFile()
    {
        file.outputStream().use { output ->
            DigestOutputStream(output, getMessageDigest()).use {
                it.write(bytes!!)
                hash = it.messageDigest.digest().toHex()
            }
        }
    }
}