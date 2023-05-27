package me.ugreek85.storage.offline_session

import me.ugreek85.storage.document_info.IDocumentInfo
import me.ugreek85.storage.document_info.IDocumentInfoStorage
import me.ugreek85.storage.stored_document.IStoredDocument
import me.ugreek85.storage.stored_document.IStoredDocumentStorage

interface IOfflineSessionStorage {

//    fun getDocumentsCount(): Int
//    fun setDocumentsCount(count: Int)

    fun getAll(registrarId: Long): List<IDocumentInfo>
    fun count(registrarId: Long): Int
    fun deleteByLocalNumber(registrarId: Long, localNumber: Long)

    fun getLastDocumentHash(registrarId: Long): String?
    fun getFirstStoredDocument(registrarId: Long): IStoredDocument?

    fun getDocumentStorage(): IStoredDocumentStorage
}