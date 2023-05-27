package me.ugreek85.builder.document.typed

import me.ugreek85.builder.document.typed.common.IBaseDocumentBuilder
import me.ugreek85.builder.document.typed.common.IOfflineAbilityBuilder

interface IServiceInputDocumentBuilder :
    IBaseDocumentBuilder<IServiceInputDocumentBuilder>,
    IOfflineAbilityBuilder<IServiceInputDocumentBuilder> {

    fun setSum(sum: Double): IServiceInputDocumentBuilder
}