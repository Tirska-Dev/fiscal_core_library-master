package me.ugreek85.builder.document.typed.impl

import me.ugreek85.document.common.DocumentType
import me.ugreek85.document.common.IDocument
import me.ugreek85.builder.document.offline_fiscal_number.IOfflineFiscalNumberBuilder
import me.ugreek85.builder.document.base.IDocumentFactories
import me.ugreek85.builder.document.typed.IBeginOfflineDocumentBuilder
import me.ugreek85.builder.document.typed.common.impl.BaseDocumentWithOfflineAbilityBuilderImpl

class BeginOfflineDocumentBuilderImpl(
    documentFactories: IDocumentFactories,
    offlineFiscalNumberBuilder: IOfflineFiscalNumberBuilder
) : BaseDocumentWithOfflineAbilityBuilderImpl<IBeginOfflineDocumentBuilder>(
    documentFactories, offlineFiscalNumberBuilder),
    IBeginOfflineDocumentBuilder {

    private var mRevokeLastOnlineDocument: Boolean? = null

    override fun setRevokeLastOnlineDocument(revokeLastOnlineDocument: Boolean?): IBeginOfflineDocumentBuilder {
        mRevokeLastOnlineDocument = revokeLastOnlineDocument
        return this
    }

    override fun build(): IDocument {

        this.setOffline(true)
        val header = buildHeader(DocumentType.BeginOffline)
        header.setRevokeLastOnlineDocument(mRevokeLastOnlineDocument)

        return createReceiptDocument(header)
    }
}