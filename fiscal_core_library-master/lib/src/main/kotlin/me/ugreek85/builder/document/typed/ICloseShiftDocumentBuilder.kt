package me.ugreek85.builder.document.typed

import me.ugreek85.builder.document.typed.common.IBaseDocumentBuilder
import me.ugreek85.builder.document.typed.common.IOfflineAbilityBuilder

interface ICloseShiftDocumentBuilder :
    IBaseDocumentBuilder<ICloseShiftDocumentBuilder>,
    IOfflineAbilityBuilder<ICloseShiftDocumentBuilder>
{
}