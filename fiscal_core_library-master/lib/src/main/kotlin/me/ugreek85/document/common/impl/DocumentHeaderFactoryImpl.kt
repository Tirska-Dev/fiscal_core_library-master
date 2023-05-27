package me.ugreek85.document.common.impl

import me.ugreek85.storage.registrar_info.IRegistrarInfo
import me.ugreek85.storage.registrar_state.IRegistrarState
import me.ugreek85.document.common.IDocumentHeader
import me.ugreek85.utils.DocumentHeaderTimeUtil
import java.util.*

class DocumentHeaderFactoryImpl : IDocumentHeaderFactory {

    override fun create(
        date: Date,
        registrarInfo: IRegistrarInfo,
        registrarState: IRegistrarState,
        cashierName: String,
    ): IDocumentHeader {

        val header = DocumentHeaderImpl()
        header.let {
            it.setVersion(1)
            it.setUid(UUID.randomUUID().toString())

            it.setDate(DocumentHeaderTimeUtil.getDateString(date))
            it.setTime(DocumentHeaderTimeUtil.getTimeString(date))

            it.setRegistrarId(registrarInfo.getRegistrarId())
            it.setRegistrarLocalNumber(registrarInfo.getRegistrarLocalNumber())
            it.setCompanyName(registrarInfo.getCompanyName())
            it.setSellerId(registrarInfo.getSellerId())
            it.setVatNumber(registrarInfo.getVatNumber())
            it.setPointName(registrarInfo.getPointName())
            it.setPointAddress(registrarInfo.getPointAddress())
            it.setDocumentNumber(registrarState.getNextDocumentNumber())
            it.setCashierName(cashierName)
        }

        return header
    }

    override fun createEmpty(): IDocumentHeader {
        return DocumentHeaderImpl()
    }
}