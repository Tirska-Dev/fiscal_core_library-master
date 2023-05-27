package me.ugreek85.document.report

import me.ugreek85.document.common.IDocumentTaxRate

interface IReportTotal {

    fun setSum(sum: Double)
    fun getSum(): Double

    fun setNumberOfReceipts(numberOfReceipts: Int)
    fun getNumberOfReceipts(): Int

    fun getPawnSumIssued(): Double?
    fun setPawnSumIssued(pawnSumIssued: Double?)

    fun getPawnSumReceived(): Double?
    fun setPawnSumReceived(pawnSumReceived: Double?)

    fun setPayForms(payForms: List<IReportPayForm>?)
    fun getPayForms(): List<IReportPayForm>?

    fun setTaxRates(taxRates: List<IDocumentTaxRate>?)
    fun getTaxRates(): List<IDocumentTaxRate>?

}
