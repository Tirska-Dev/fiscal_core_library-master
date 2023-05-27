package me.ugreek85.storage.stored_document.impl.file

import me.ugreek85.storage.document_info.IDocumentInfo
import me.ugreek85.storage.stored_document.IStoredDocumentStorage
import java.io.File

class OnlineStoredDocumentStorageImpl(
    workingDirectory: File
) : IStoredDocumentStorage, StoredDocumentStorage(workingDirectory)  {

    override fun getPath(registrarId: Long, localNumber: Long, createIfNotExists: Boolean): File
    {
        return File(getRootPathForDocuments(registrarId, createIfNotExists), localNumber.toString())
    }
}