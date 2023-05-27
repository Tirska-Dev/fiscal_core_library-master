package me.ugreek85.document.receipt.impl

import me.ugreek85.builder.document.base.IReceiptDocumentFactoriesSet
import me.ugreek85.document.receipt.IPaymentDetails
import me.ugreek85.document.receipt.IReceiptPayForm
import me.ugreek85.document.report.impl.ReportDocumentPayFormImpl
import me.ugreek85.utils.DocumentCopyUtil

class ReceiptDocumentPayFormImpl(
    private val mReceiptDocumentFactoriesSet: IReceiptDocumentFactoriesSet? = null
) : IReceiptPayForm, ReportDocumentPayFormImpl(){

    private var mProvidedSum: Double? = null
    private var mSumOfRemain: Double? = null
    private var mPaymentDetails: IPaymentDetails? = null

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
        mPaymentDetails = DocumentCopyUtil.copyObject(IPaymentDetails::class.java, paymentDetails){
            mReceiptDocumentFactoriesSet?.newPaymentDetails() ?: PaymentDetailsImpl()
        }
    }
}