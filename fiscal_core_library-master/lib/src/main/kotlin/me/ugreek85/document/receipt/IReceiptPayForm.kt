package me.ugreek85.document.receipt

import me.ugreek85.document.report.IReportPayForm

interface IReceiptPayForm : IReportPayForm {

    fun setProvidedSum(providedSum: Double?)
    fun getProvidedSum(): Double?

    fun setSumOfRemain(sumOfRemain: Double?)
    fun getSumOfRemain(): Double?

    fun getPaymentDetails(): IPaymentDetails?
    fun setPaymentDetails(paymentDetails: IPaymentDetails?)
}