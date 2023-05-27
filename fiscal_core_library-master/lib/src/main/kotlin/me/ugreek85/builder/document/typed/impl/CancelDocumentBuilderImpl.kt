package me.ugreek85.builder.document.typed.impl

import me.ugreek85.builder.document.offline_fiscal_number.IOfflineFiscalNumberBuilder
import me.ugreek85.builder.document.base.IDocumentFactories
import me.ugreek85.builder.document.typed.ICancelDocumentBuilder
import me.ugreek85.builder.document.typed.common.impl.BaseDocumentWithOfflineAbilityBuilderImpl
import me.ugreek85.document.common.DocumentType
import me.ugreek85.document.common.IDocument

class CancelDocumentBuilderImpl(
    documentFactories: IDocumentFactories,
    offlineFiscalNumberBuilder: IOfflineFiscalNumberBuilder
) :
    BaseDocumentWithOfflineAbilityBuilderImpl<ICancelDocumentBuilder>(
        documentFactories, offlineFiscalNumberBuilder),
    ICancelDocumentBuilder
{
    private lateinit var mFiscalNumberForDelete: String

    override fun setFiscalNumberForDelete(fiscalNumberForDelete: String): ICancelDocumentBuilder {
        mFiscalNumberForDelete = fiscalNumberForDelete
        return this
    }

    override fun build(): IDocument {
        val header = buildHeader(DocumentType.Cancel)
        header.setFiscalNumberForCancel(mFiscalNumberForDelete)

        return createReceiptDocument(header)
    }
}