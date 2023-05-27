package me.ugreek85.builder.document.typed.impl

import me.ugreek85.builder.document.offline_fiscal_number.IOfflineFiscalNumberBuilder
import me.ugreek85.builder.document.base.IDocumentFactories
import me.ugreek85.builder.document.typed.IZReportDocumentBuilder
import me.ugreek85.builder.document.typed.common.impl.BaseDocumentWithOfflineAbilityBuilderImpl
import me.ugreek85.document.common.DocumentType
import me.ugreek85.document.common.IDocument
import me.ugreek85.document.report.IReportTotal
import kotlin.properties.Delegates

class ZReportDocumentBuilderImpl(
    documentFactories: IDocumentFactories,
    offlineFiscalNumberBuilder: IOfflineFiscalNumberBuilder,
) :
    BaseDocumentWithOfflineAbilityBuilderImpl<IZReportDocumentBuilder>(
        documentFactories, offlineFiscalNumberBuilder),
    IZReportDocumentBuilder
{
    private var mTotalsBySale: IReportTotal? = null
    private var mTotalsByReturn: IReportTotal? = null
    private var mServiceInputSum by Delegates.notNull<Double>()
    private var mServiceOutputSum by Delegates.notNull<Double>()

    override fun setTotalsBySale(totals: IReportTotal?): IZReportDocumentBuilder {
        mTotalsBySale = totals
        return this
    }

    override fun setTotalsByReturn(totals: IReportTotal?): IZReportDocumentBuilder {
        mTotalsByReturn = totals
        return this
    }

    override fun setServiceInputSum(sum: Double): IZReportDocumentBuilder {
        mServiceInputSum = sum
        return this
    }

    override fun setServiceOutputSum(sum: Double): IZReportDocumentBuilder {
        mServiceOutputSum = sum
        return this
    }

    override fun build(): IDocument {
        val header = buildHeader(DocumentType.ZReport)

        val document = getDocumentFactories()
            .getReportDocumentFactoriesSet()
            .newReportDocument()
            .apply {
                setDocumentHeader(header)
            }

        document.setServiceInputSum(mServiceInputSum)
        document.setServiceOutputSum(mServiceOutputSum)
        document.setTotalsByReturn(mTotalsByReturn)
        document.setTotalsBySale(mTotalsBySale)

        return document
    }
}