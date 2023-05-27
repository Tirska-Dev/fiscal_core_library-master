package me.ugreek85.view.json.impl.receipt

import com.google.gson.annotations.SerializedName
import me.ugreek85.document.receipt.IPaymentDetails
import me.ugreek85.document.receipt.IReceiptPayForm
import me.ugreek85.document.report.impl.ReportDocumentPayFormImpl
import me.ugreek85.utils.DocumentCopyUtil
import me.ugreek85.view.json.impl.report.JsonReportDocumentPayForm
import me.ugreek85.view.xml.impl.receipt.XmlPaymentDetails
import org.simpleframework.xml.Element

class JsonReceiptDocumentPayForm : IReceiptPayForm, JsonReportDocumentPayForm(){

    @SerializedName("providedSum")
    private var mProvidedSum: Double? = null

    @SerializedName("sumOfRemain")
    private var mSumOfRemain: Double? = null

    @SerializedName("paymentDetails")
    private var mPaymentDetails: JsonPaymentDetails? = null

    override fun setProvidedSum(providedSum: Double?) {
        mProvidedSum = providedSum
    }

    override fun getProvidedSum(): Double? {
        return mProvidedSum
    }

    override fun setSumOfRemain(sumOfRemain: Double?) {
        mSumOfRemain = sumOfRemain
    }

    override fun getSumOfRemain(): Double? {
        return mSumOfRemain
    }

    override fun getPaymentDetails(): IPaymentDetails? {
        return mPaymentDetails
    }

    override fun setPaymentDetails(paymentDetails: IPaymentDetails?) {
        mPaymentDetails = DocumentCopyUtil.copyObject2(IPaymentDetails::class.java, paymentDetails){
            JsonPaymentDetails()
        }
    }
}