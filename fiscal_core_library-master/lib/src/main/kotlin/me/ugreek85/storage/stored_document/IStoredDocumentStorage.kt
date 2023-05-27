package me.ugreek85.storage.stored_document

import me.ugreek85.storage.document_info.IDocumentInfo

interface IStoredDocumentStorage {

    fun get(registrarId: Long, localNumber: Long): IStoredDocument?
    fun get(documentInfo: IDocumentInfo): IStoredDocument?

    fun save(documentInfo: IDocumentInfo, bytes: ByteArray): IStoredDocument
    fun save(registrarId: Long, localNumber: Long, bytes: ByteArray): IStoredDocument
}