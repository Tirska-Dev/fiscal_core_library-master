package me.ugreek85.builder.document.typed

import me.ugreek85.builder.document.typed.common.IBaseDocumentBuilder

interface IBeginOfflineDocumentBuilder : IBaseDocumentBuilder<IBeginOfflineDocumentBuilder> {

    fun setRevokeLastOnlineDocument(revokeLastOnlineDocument: Boolean?): IBeginOfflineDocumentBuilder
}