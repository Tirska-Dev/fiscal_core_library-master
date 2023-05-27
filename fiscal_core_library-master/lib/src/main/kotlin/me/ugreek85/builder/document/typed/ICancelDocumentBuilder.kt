package me.ugreek85.builder.document.typed

import me.ugreek85.builder.document.typed.common.IBaseDocumentBuilder
import me.ugreek85.builder.document.typed.common.IOfflineAbilityBuilder

interface ICancelDocumentBuilder :
    IBaseDocumentBuilder<ICancelDocumentBuilder>,
    IOfflineAbilityBuilder<ICancelDocumentBuilder> {

    fun setFiscalNumberForDelete(fiscalNumberForDelete: String): ICancelDocumentBuilder
}