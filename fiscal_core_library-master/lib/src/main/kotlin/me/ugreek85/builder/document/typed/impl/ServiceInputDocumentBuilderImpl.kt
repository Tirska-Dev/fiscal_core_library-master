package me.ugreek85.builder.document.typed.impl

import me.ugreek85.builder.document.offline_fiscal_number.IOfflineFiscalNumberBuilder
import me.ugreek85.builder.document.base.IDocumentFactories
import me.ugreek85.builder.document.typed.IServiceInputDocumentBuilder
import me.ugreek85.builder.document.typed.common.impl.BaseDocumentWithOfflineAbilityBuilderImpl
import me.ugreek85.document.common.DocumentType
import me.ugreek85.document.common.IDocument
import kotlin.properties.Delegates

class ServiceInputDocumentBuilderImpl(
    documentFactories: IDocumentFactories,
    offlineFiscalNumberBuilder: IOfflineFiscalNumberBuilder,
) :
    BaseDocumentWithOfflineAbilityBuilderImpl<IServiceInputDocumentBuilder>(
        documentFactories, offlineFiscalNumberBuilder),
    IServiceInputDocumentBuilder
{
    private var mSum by Delegates.notNull<Double>()

    override fun setSum(sum: Double): IServiceInputDocumentBuilder {
        mSum = sum
        return this
    }

    override fun build(): IDocument {
        val header = buildHeader(DocumentType.ServiceInput)

        val document = createReceiptDocument(header)

        document.setTotal(

            getDocumentFactories()
                .getReceiptDocumentFactoriesSet()
                .newReceiptTotal()
                .apply {
                    setSum(mSum)
                }
        )

        return document
    }

    override fun addingAdditionalParamsToOfflineFiscalNumberBuilder(offlineFiscalNumberBuilder: IOfflineFiscalNumberBuilder): IOfflineFiscalNumberBuilder {
        super.addingAdditionalParamsToOfflineFiscalNumberBuilder(offlineFiscalNumberBuilder)
        offlineFiscalNumberBuilder.setSum(mSum)
        return offlineFiscalNumberBuilder
    }
}