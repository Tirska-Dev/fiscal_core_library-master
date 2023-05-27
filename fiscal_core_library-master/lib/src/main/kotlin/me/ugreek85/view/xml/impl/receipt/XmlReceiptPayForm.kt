package me.ugreek85.view.xml.impl.receipt

import me.ugreek85.document.receipt.IPaymentDetails
import me.ugreek85.document.receipt.IReceiptPayForm
import me.ugreek85.document.receipt.impl.PaymentDetailsImpl
import me.ugreek85.utils.CopyObjectUtil
import me.ugreek85.utils.DocumentCopyUtil
import me.ugreek85.view.xml.impl.report.XmlReportPayForm
import me.ugreek85.view.xml.impl.types.Decimal2
import me.ugreek85.view.xml.impl.util.DecimalUtil
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

class XmlReceiptPayForm : IReceiptPayForm, XmlReportPayForm() {

    @field:Element(name="PROVIDED", required = false)
    private var mProvidedSum: Decimal2? = null

    @field:Element(name="REMAINS", required = false)
    private var mSumOfRemain: Decimal2? = null

    @field:ElementList(name="PAYSYS", required = false)
    private var mPaymentDetails: ArrayList<XmlPaymentDetails>? = null

    override fun setProvidedSum(providedSum: Double?) {
        mProvidedSum = DecimalUtil.create(providedSum)
    }

    override fun getProvidedSum(): Double? {
        return DecimalUtil.getDoubleValue(mProvidedSum)
    }

    override fun setSumOfRemain(sumOfRemain: Double?) {
        mSumOfRemain = DecimalUtil.create(sumOfRemain)
    }

    override fun getSumOfRemain(): Double? {
        return DecimalUtil.getDoubleValue(mSumOfRemain)
    }

    override fun getPaymentDetails(): IPaymentDetails? {
        val array = mPaymentDetails ?: return null
        if(array.isNotEmpty()) return array[0]
        return null
    }

    override fun setPaymentDetails(paymentDetails: IPaymentDetails?) {
        if(paymentDetails== null)
        {
            mPaymentDetails = paymentDetails
            return
        }
        if(mPaymentDetails?.isNotEmpty() == true)
        {
            mPaymentDetails = ArrayList<XmlPaymentDetails>().apply {
                add(
                    XmlPaymentDetails().apply {
                        CopyObjectUtil.copyByInterface(IPaymentDetails::class.java, paymentDetails, this)
                    }
                )
            }
        }

    }

    override fun toString(): String {
        return "XmlReceiptPayForm(mProvidedSum=$mProvidedSum, mSumOfRemain=$mSumOfRemain, mPaymentDetails=$mPaymentDetails)"
    }

}