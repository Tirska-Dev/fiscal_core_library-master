package me.ugreek85.storage.document_info

import me.ugreek85.storage.stored_document.IStoredDocumentStorage

interface IDocumentInfoStorage {

    fun new(): IDocumentInfo

    fun add(documentInfo: IDocumentInfo)
    fun update(documentInfo: IDocumentInfo)

    fun getByFiscalNumber(registrarId: Long, fiscalNumber: String): IDocumentInfo?
    fun getByLocalNumber(registrarId: Long, localNumber: Long): IDocumentInfo?

    fun getAllByShiftId(registrarId: Long, shiftId: String): List<IDocumentInfo>
    fun count(registrarId: Long): Long

    fun getLast(registrarId: Long): IDocumentInfo?
    fun getTmp(registrarId: Long): IDocumentInfo?

    fun getDocumentStorage(): IStoredDocumentStorage

//    fun removeAllDocumentsOlderThan3Years(registrarId: Long)
//    fun removeAllDocumentsOlderThan3Years()
}