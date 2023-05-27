package me.ugreek85.builder.document.offline_fiscal_number

import me.ugreek85.builder.IBaseBuilder

interface IOfflineFiscalNumberBuilder : IBaseBuilder<String> {

    fun setOfflineSessionId(offlineSessionId: String): IOfflineFiscalNumberBuilder
    fun setOfflineDocumentNumber(offlineDocumentNumber: Long): IOfflineFiscalNumberBuilder

    fun setOfflineSeed(offlineSeed: String): IOfflineFiscalNumberBuilder
    fun setDate(date: String): IOfflineFiscalNumberBuilder
    fun setTime(time: String): IOfflineFiscalNumberBuilder
    fun setDocumentNumber(documentNumber: Long): IOfflineFiscalNumberBuilder
    fun setRegistrarId(registrarId: Long): IOfflineFiscalNumberBuilder
    fun setRegistrarLocalNumber(registrarLocalNumber: Long): IOfflineFiscalNumberBuilder
    fun setSum(sum: Double?): IOfflineFiscalNumberBuilder
    fun setPreviousDocumentHash(previousDocumentHash: String?): IOfflineFiscalNumberBuilder
}