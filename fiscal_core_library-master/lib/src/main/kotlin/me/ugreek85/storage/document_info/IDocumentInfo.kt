package me.ugreek85.storage.document_info

import me.ugreek85.document.common.DocumentType
import java.util.*

interface IDocumentInfo {

    fun getDate(): Date
    fun setDate(date: Date)

    fun getRegistrarId(): Long
    fun setRegistrarId(registrarId: Long)

    fun getLocalNumber(): Long
    fun setLocalNumber(localNumber: Long)

    fun getFiscalNumber(): String?
    fun setFiscalNumber(fiscalNumber: String?)

    fun getShiftId(): String?
    fun setShiftId(shiftId: String?)

    fun getDocumentType(): DocumentType
    fun setDocumentType(documentType: DocumentType)

    fun isRevoked(): Boolean
    fun setRevoked(revoked: Boolean)

    fun isCanceled(): Boolean
    fun setCanceled(canceled: Boolean)

    fun getState(): DocumentInfoState
    fun setState(state: DocumentInfoState)

    fun getHash(): String?
    fun setHash(hash: String?)
}