@file:Suppress("UNCHECKED_CAST")

package me.ugreek85.builder.document.typed.common.impl

import me.ugreek85.builder.document.typed.common.IBaseDocumentBuilder
import me.ugreek85.builder.document.offline_fiscal_number.IOfflineFiscalNumberBuilder
import me.ugreek85.builder.document.base.IDocumentFactories
import me.ugreek85.document.common.DocumentType
import me.ugreek85.document.common.IDocumentHeader
import me.ugreek85.document.receipt.IReceiptDocument
import me.ugreek85.storage.registrar_info.IRegistrarInfo
import me.ugreek85.storage.registrar_state.IRegistrarState
import me.ugreek85.utils.DocumentHeaderTimeUtil
import me.ugreek85.utils.DocumentTypeUtil
import java.util.*

abstract class BaseDocumentBuilderImpl<T>
    (
    private val mDocumentFactories: IDocumentFactories,
    private val mOfflineFiscalNumberBuilder: IOfflineFiscalNumberBuilder
): IBaseDocumentBuilder<T> {

    private var mDate: Date = Date()
    private lateinit var mRegistrarInfo: IRegistrarInfo
    private lateinit var mRegistrarState: IRegistrarState
    private lateinit var mCashierName: String

    override fun setDate(date: Date): T {
        mDate = date
        return this as T
    }

    override fun setRegistrarInfo(registrarInfo: IRegistrarInfo): T {
        mRegistrarInfo = registrarInfo
        return this as T
    }

    override fun setRegistrarState(registrarState: IRegistrarState): T {
        mRegistrarState = registrarState
        return this as T
    }

    override fun setCashierName(cashierName: String): T {
        mCashierName = cashierName
        return this as T
    }

    protected open fun getOfflineFiscalNumberBuilder(): IOfflineFiscalNumberBuilder
    {
        return mOfflineFiscalNumberBuilder
    }

    protected open fun buildHeader(documentType: DocumentType): IDocumentHeader
    {
        return mDocumentFactories.getDocumentFactoriesSet().newDocumentHeader().apply {
            setVersion(1)
            setUid(UUID.randomUUID().toString())

            setDate(DocumentHeaderTimeUtil.getDateString(mDate))
            setTime(DocumentHeaderTimeUtil.getTimeString(mDate))

            setRegistrarId(mRegistrarInfo.getRegistrarId())
            setRegistrarLocalNumber(mRegistrarInfo.getRegistrarLocalNumber())
            setCompanyName(mRegistrarInfo.getCompanyName())
            setSellerId(mRegistrarInfo.getSellerId())
            setVatNumber(mRegistrarInfo.getVatNumber())
            setPointName(mRegistrarInfo.getPointName())
            setPointAddress(mRegistrarInfo.getPointAddress())
            setDocumentNumber(mRegistrarState.getNextDocumentNumber())
            setCashierName(mCashierName)

            DocumentTypeUtil.fillDocumentHeaderByDocumentType(this, documentType)
        }
    }

    protected fun getRegistrarState(): IRegistrarState
    {
        return mRegistrarState
    }

    protected fun getRegistrarInfo(): IRegistrarInfo
    {
        return mRegistrarInfo
    }

    protected fun getDocumentFactories(): IDocumentFactories
    {
        return mDocumentFactories
    }

    protected fun createReceiptDocument(documentHeader: IDocumentHeader): IReceiptDocument
    {
        return getDocumentFactories()
            .getReceiptDocumentFactoriesSet()
            .newReceiptDocument()
            .apply {
                setDocumentHeader(documentHeader)
            }
    }
}