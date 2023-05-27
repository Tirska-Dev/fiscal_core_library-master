package me.ugreek85.document.common

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


interface IDocumentHeader {

    fun setInternalDocumentType(internalDocumentType: InternalDocumentType?)
    fun getInternalDocumentType(): InternalDocumentType?

    fun setInternalDocumentSubType(internalDocumentSubType: InternalDocumentSubType?)
    fun getInternalDocumentSubType(): InternalDocumentSubType?

    fun getUid(): String
    fun setUid(uid: String)

    fun setSellerId(sellerId: String)
    fun getSellerId(): String

    fun setVatNumber(vatNumber: String?)
    fun getVatNumber(): String?

    fun setCompanyName(companyName: String)
    fun getCompanyName(): String

    fun setPointName(pointName: String)
    fun getPointName(): String

    fun setPointAddress(pointAddress: String)
    fun getPointAddress(): String

    fun setDate(date: String)
    fun getDate(): String

    fun setTime(time: String)
    fun getTime(): String

    fun setDocumentNumber(documentNumber: Long)
    fun getDocumentNumber(): Long

    fun setRegistrarLocalNumber(registrarLocalNumber: Long)
    fun getRegistrarLocalNumber(): Long

    fun setRegistrarId(registrarId: Long)
    fun getRegistrarId(): Long

    fun setFiscalNumberForReturn(fiscalNumberForReturn: String?)
    fun getFiscalNumberForReturn(): String?

    fun setFiscalNumberForCancel(fiscalNumberForCancel: String?)
    fun getFiscalNumberForCancel(): String?

    fun setRevokeLastOnlineDocument(revokeLastOnlineDocument: Boolean?)
    fun isRevokeLastOnlineDocument(): Boolean?

    fun setCashierName(cashierName: String?)
    fun getCashierName(): String?

    fun setLogoUrl(logoUrl: String?)
    fun getLogoUrl(): String?

    fun setComment(comment: String?)
    fun getComment(): String?

    fun setVersion(version: Int)
    fun getVersion(): Int

    fun setFiscalNumber(fiscalNumber: String?)
    fun getFiscalNumber(): String?

    fun setRevoked(revoked: Boolean?)
    fun isRevoked(): Boolean?

    fun setCanceled(canceled: Boolean?)
    fun isCanceled(): Boolean?

    fun setOffline(offline: Boolean?)
    fun isOffline(): Boolean?

    fun setPreviousDocumentHash(previousDocumentHash: String?)
    fun getPreviousDocumentHash(): String?

    fun setTest(test: Boolean?)
    fun isTest(): Boolean?

    fun getDateTime(): LocalDateTime
    {
        if(getDate().isNotEmpty() && getTime().isNotEmpty())
        {
            return LocalDateTime.parse("${getDate()}${getTime()}", DateTimeFormatter.ofPattern("ddMMyyyyHHmmss"))
        }

        throw IllegalStateException("field Date or Time is not filled")
    }
}
