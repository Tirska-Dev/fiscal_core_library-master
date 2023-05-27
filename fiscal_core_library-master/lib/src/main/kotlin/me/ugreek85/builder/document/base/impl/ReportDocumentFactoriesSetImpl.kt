package me.ugreek85.builder.document.base.impl

import me.ugreek85.builder.document.base.IDocumentFactories
import me.ugreek85.builder.document.base.IReportDocumentFactoriesSet
import me.ugreek85.document.report.IReportCashTotal
import me.ugreek85.document.report.IReportDocument
import me.ugreek85.document.report.IReportPayForm
import me.ugreek85.document.report.IReportTotal
import me.ugreek85.document.report.impl.ReportCashTotalImpl
import me.ugreek85.document.report.impl.ReportDocumentImpl
import me.ugreek85.document.report.impl.ReportDocumentPayFormImpl
import me.ugreek85.document.report.impl.ReportTotalImpl

class ReportDocumentFactoriesSetImpl(
    private val mDocumentFactories: IDocumentFactories
) : IReportDocumentFactoriesSet {

    override fun newReportDocument(): IReportDocument {
        return ReportDocumentImpl(mDocumentFactories)
    }

    override fun newReportTotal(): IReportTotal {
        return ReportTotalImpl(mDocumentFactories)
    }

    override fun newReportPayForm(): IReportPayForm {
        return ReportDocumentPayFormImpl()
    }

    override fun newReportCashTotal(): IReportCashTotal {
        return ReportCashTotalImpl()
    }
}