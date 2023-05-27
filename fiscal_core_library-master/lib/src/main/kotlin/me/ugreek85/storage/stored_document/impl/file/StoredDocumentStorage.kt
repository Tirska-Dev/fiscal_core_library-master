package me.ugreek85.storage.stored_document.impl.file

import me.ugreek85.storage.common.PathAbility
import me.ugreek85.storage.document_info.IDocumentInfo
import me.ugreek85.storage.stored_document.IStoredDocument
import me.ugreek85.storage.stored_document.IStoredDocumentStorage
import java.io.File

abstract class StoredDocumentStorage(
    workingDirectory: File
) : IStoredDocumentStorage, PathAbility(workingDirectory) {

    abstract fun getPath(registrarId: Long, localNumber: Long, createIfNotExists: Boolean = false): File

    private fun getPath(documentInfo: IDocumentInfo, createIfNotExists: Boolean = false): File
    {
        return getPath(documentInfo.getRegistrarId(), documentInfo.getLocalNumber(), createIfNotExists)
    }

    override fun get(registrarId: Long, localNumber: Long): IStoredDocument? {
        val file = getPath(registrarId, localNumber)
        if(file.exists()) return StoredDocumentImpl(file)
        return null
    }

    override fun get(documentInfo: IDocumentInfo): IStoredDocument? {
        return get(documentInfo.getRegistrarId(), documentInfo.getLocalNumber())
    }

    override fun save(documentInfo: IDocumentInfo, bytes: ByteArray): IStoredDocument {
        return save(documentInfo.getRegistrarId(), documentInfo.getLocalNumber(), bytes)
    }

    override fun save(registrarId: Long, localNumber: Long, bytes: ByteArray): IStoredDocument {
        return StoredDocumentImpl(getPath(registrarId, localNumber, true), bytes).apply {
            writeFile()
        }
    }
}