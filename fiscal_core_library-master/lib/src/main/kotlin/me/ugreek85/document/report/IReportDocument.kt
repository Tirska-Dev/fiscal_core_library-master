package me.ugreek85.document.report

import me.ugreek85.document.common.IDocument

interface IReportDocument : IDocument {

    fun setTotalsBySale(totals: IReportTotal?)
    fun getTotalsBySale(): IReportTotal?

    fun setTotalsByReturn(totals: IReportTotal?)
    fun getTotalsByReturn(): IReportTotal?

    fun setServiceInputSum(sum: Double)
    fun getServiceInputSum(): Double

    fun setServiceOutputSum(sum: Double)
    fun getServiceOutputSum(): Double

    fun setTotalsByCash(totals: IReportCashTotal?)
    fun getTotalsByCash(): IReportCashTotal?
}