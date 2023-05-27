package me.ugreek85.view.xml.impl.report

import me.ugreek85.document.common.IDocumentTaxRate
import me.ugreek85.document.report.IReportPayForm
import me.ugreek85.document.report.IReportTotal
import me.ugreek85.utils.DocumentCopyUtil
import me.ugreek85.view.xml.impl.document.XmlDocumentTaxRate
import me.ugreek85.view.xml.impl.types.Decimal2
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList

class XmlReportTotal : IReportTotal {

    @field:Element(name="SUM")
    private var mSum = Decimal2()

    @field:Element(name="ORDERSCNT")
    private var mNumberOfReceipts: Int = 0

    @field:Element(name="PWNSUMISSUED", required = false)
    private var mPawnSumIssued: Double? = null

    @field:Element(name="PWNSUMRECEIVED", required = false)
    private var mPawnSumReceived: Double? = null

    @field:ElementList(name = "PAYFORMS", required = false)
    var mPayForms: ArrayList<XmlReportPayForm>? = null

    @field:ElementList(name = "TAXES", required = false)
    var mTaxRates: ArrayList<XmlDocumentTaxRate>? = null

    override fun setSum(sum: Double) {
        mSum.setValue(sum)
    }

    override fun getSum(): Double {
        return mSum.getValue().toDouble()
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

        mPayForms = DocumentCopyUtil.copyArrayList(IReportPayForm::class.java, payForms){
            XmlReportPayForm()
        }

    }

    override fun getPayForms(): List<IReportPayForm>? {
        return mPayForms
    }

    override fun setTaxRates(taxRates: List<IDocumentTaxRate>?) {

        mTaxRates = DocumentCopyUtil.copyArrayList(IDocumentTaxRate::class.java, taxRates){
            XmlDocumentTaxRate()
        }

    }

    override fun getTaxRates(): List<IDocumentTaxRate>? {
        return mTaxRates
    }

    override fun toString(): String {
        return "XmlReportTotal(mSum=$mSum, mNumberOfReceipts=$mNumberOfReceipts, mPayForms=$mPayForms, mTaxRates=$mTaxRates)"
    }
}
