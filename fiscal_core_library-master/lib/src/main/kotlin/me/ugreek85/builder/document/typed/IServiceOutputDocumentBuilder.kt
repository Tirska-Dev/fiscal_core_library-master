package me.ugreek85.builder.document.typed

import me.ugreek85.builder.document.typed.common.IBaseDocumentBuilder
import me.ugreek85.builder.document.typed.common.IOfflineAbilityBuilder

interface IServiceOutputDocumentBuilder :
    IBaseDocumentBuilder<IServiceOutputDocumentBuilder>,
    IOfflineAbilityBuilder<IServiceOutputDocumentBuilder> {

    fun setSum(sum: Double): IServiceOutputDocumentBuilder
}