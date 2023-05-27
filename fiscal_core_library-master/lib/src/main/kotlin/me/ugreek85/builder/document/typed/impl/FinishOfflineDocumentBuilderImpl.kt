package me.ugreek85.builder.document.typed.impl

import me.ugreek85.document.common.DocumentType
import me.ugreek85.document.common.IDocument
import me.ugreek85.builder.document.offline_fiscal_number.IOfflineFiscalNumberBuilder
import me.ugreek85.builder.document.base.IDocumentFactories
import me.ugreek85.builder.document.typed.IFinishOfflineDocumentBuilder
import me.ugreek85.builder.document.typed.common.impl.BaseDocumentWithOfflineAbilityBuilderImpl

class FinishOfflineDocumentBuilderImpl(
    documentFactories: IDocumentFactories,
    offlineFiscalNumberBuilder: IOfflineFiscalNumberBuilder
) : BaseDocumentWithOfflineAbilityBuilderImpl<IFinishOfflineDocumentBuilder>(
    documentFactories, offlineFiscalNumberBuilder),
    IFinishOfflineDocumentBuilder {


    override fun build(): IDocument {

        this.setOffline(true)
        val header = buildHeader(DocumentType.FinishOffline)

        return createReceiptDocument(header)
    }
}