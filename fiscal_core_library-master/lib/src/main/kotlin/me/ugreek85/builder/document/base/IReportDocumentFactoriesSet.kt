package me.ugreek85.builder.document.base

import me.ugreek85.document.report.IReportCashTotal
import me.ugreek85.document.report.IReportDocument
import me.ugreek85.document.report.IReportPayForm
import me.ugreek85.document.report.IReportTotal

interface IReportDocumentFactoriesSet {

    fun newReportDocument(): IReportDocument
    fun newReportTotal(): IReportTotal
    fun newReportPayForm(): IReportPayForm
    fun newReportCashTotal(): IReportCashTotal
}