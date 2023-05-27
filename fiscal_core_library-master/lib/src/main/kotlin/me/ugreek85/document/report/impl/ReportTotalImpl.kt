package me.ugreek85.document.report.impl

import me.ugreek85.builder.document.base.IDocumentFactories
import me.ugreek85.document.common.IDocumentTaxRate
import me.ugreek85.document.report.IReportPayForm
import me.ugreek85.document.report.IReportTotal
import me.ugreek85.utils.DocumentCopyUtil
import kotlin.properties.Delegates

class ReportTotalImpl(
    private val mDocumentFactories: IDocumentFactories
) : IReportTotal {

    private var mSum by Delegates.notNull<Double>()
    private var mNumberOfReceipts by Delegates.notNull<Int>()
    private var mPawnSumIssued: Double? = null
    private var mPawnSumReceived: Double? = null
    private var mPayForms: List<IReportPayForm>? = null
    private var mTaxRates: List<IDocumentTaxRate>? = null

    override fun setSum(sum: Double) {
        mSum = sum
    }

    override fun getSum(): Double {
        return mSum
    }

    override fun setNumberOfReceipts(numberOfReceipts: Int) {
        mNumberOfReceipts = numberOfReceipts
    }

    override fun getNumberOfReceipts(): Int {
        return mNumberOfReceipts
    }

    override fun getPawnSumIssued(): Double? {
        return mPawnSumIssued
    }

    override fun setPawnSumIssued(pawnSumIssued: Double?) {
        mPawnSumIssued = pawnSumIssued
    }

    override fun getPawnSumReceived(): Double? {
        return mPawnSumReceived
    }

    override fun setPawnSumReceived(pawnSumReceived: Double?) {
        mPawnSumReceived = pawnSumReceived
    }

    override fun setPayForms(payForms: List<IReportPayForm>?) {

        mPayForms = DocumentCopyUtil.copyList(IReportPayForm::class.java, payForms) {
            mDocumentFactories.getReportDocumentFactoriesSet().newReportPayForm()
        }
    }

    override fun getPayForms(): List<IReportPayForm>? {
        return mPayForms
    }

    override fun setTaxRates(taxRates: List<IDocumentTaxRate>?) {
        mTaxRates = DocumentCopyUtil.copyList(IDocumentTaxRate::class.java, taxRates) {
            mDocumentFactories.getDocumentFactoriesSet().newDocumentTaxRate()
        }
    }

    override fun getTaxRates(): List<IDocumentTaxRate>? {
        return mTaxRates
    }
}
