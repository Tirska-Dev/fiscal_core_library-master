package me.ugreek85.builder.document.typed.impl

import me.ugreek85.builder.document.offline_fiscal_number.IOfflineFiscalNumberBuilder
import me.ugreek85.builder.document.base.IDocumentFactories
import me.ugreek85.builder.document.typed.IOpenShiftDocumentBuilder
import me.ugreek85.builder.document.typed.common.impl.BaseDocumentWithOfflineAbilityBuilderImpl
import me.ugreek85.document.common.DocumentType
import me.ugreek85.document.common.IDocument

class OpenShiftDocumentBuilderImpl(
    documentFactories: IDocumentFactories,
    offlineFiscalNumberBuilder: IOfflineFiscalNumberBuilder
) :
    BaseDocumentWithOfflineAbilityBuilderImpl<IOpenShiftDocumentBuilder>(
        documentFactories, offlineFiscalNumberBuilder),
    IOpenShiftDocumentBuilder
{
    override fun build(): IDocument {
        val header = buildHeader(DocumentType.OpenShift)

        return createReceiptDocument(header)
    }
}