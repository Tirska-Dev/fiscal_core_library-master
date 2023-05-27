package me.ugreek85.storage.stored_document.impl

import me.ugreek85.storage.stored_document.impl.file.StoredDocumentImpl
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File
import java.io.FileNotFoundException

internal class StoredDocumentImplTest {

    private val file = File("src/test/resources/stored_document.txt")
    private val document = StoredDocumentImpl(file)

    private val file2 = File("src/test/resources/stored_document_not_found.txt")
    private val document2 = StoredDocumentImpl(file2)


    @Test
    fun getFile() {
        assertEquals(file.absolutePath, document.getFile().absolutePath)
        assertEquals(file2.absolutePath, document2.getFile().absolutePath)

    }

    @Test
    fun getSize() {
        assertEquals(20, document.getSize())
        assertEquals(0, document2.getSize())

    }

    @Test
    fun getBytes() {

        assertEquals("Test Stored Document", String(document.getBytes()))
        org.junit.jupiter.api.assertThrows<FileNotFoundException> {
            document2.getBytes()
        }
    }

    @Test
    fun getHash() {

        assertEquals("bb8ec1d8fe96a6f9034dd8e038313f6908c1eecfb708360c9cbf4cb07c87d990", document.getHash())
        org.junit.jupiter.api.assertThrows<FileNotFoundException> {
            document2.getHash()
        }
    }
}