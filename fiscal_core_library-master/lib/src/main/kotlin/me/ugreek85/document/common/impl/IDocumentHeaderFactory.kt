package me.ugreek85.document.common.impl

import me.ugreek85.storage.registrar_info.IRegistrarInfo
import me.ugreek85.storage.registrar_state.IRegistrarState
import me.ugreek85.document.common.IDocumentHeader
import java.util.*

interface IDocumentHeaderFactory {

    fun create(
        date: Date,
        registrarInfo: IRegistrarInfo,
        registrarState: IRegistrarState,
        cashierName: String
    ): IDocumentHeader

    fun createEmpty(): IDocumentHeader
}