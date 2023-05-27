package me.ugreek85.builder.document.typed

import me.ugreek85.builder.document.typed.common.IBaseDocumentBuilder

interface IFinishOfflineDocumentBuilder :
    IBaseDocumentBuilder<IFinishOfflineDocumentBuilder> {

    fun setPreviousDocumentHash(hash: String?): IFinishOfflineDocumentBuilder
}