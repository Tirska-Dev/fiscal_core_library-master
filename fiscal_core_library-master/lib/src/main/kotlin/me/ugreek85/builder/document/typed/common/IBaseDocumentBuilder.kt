package me.ugreek85.builder.document.typed.common

import me.ugreek85.document.common.IDocument
import me.ugreek85.storage.registrar_info.IRegistrarInfo
import me.ugreek85.storage.registrar_state.IRegistrarState
import me.ugreek85.builder.IBaseBuilder
import java.util.*

interface IBaseDocumentBuilder<T> : IBaseBuilder<IDocument> {
    fun setDate(date: Date): T
    fun setRegistrarInfo(registrarInfo: IRegistrarInfo): T
    fun setRegistrarState(registrarState: IRegistrarState): T
    fun setCashierName(cashierName: String): T
}