package me.ugreek85.document.report

interface IReportCashTotal {

    fun setSum(sum: Double)
    fun getSum(): Double

    fun setNumberOfReceipts(numberOfReceipts: Int)
    fun getNumberOfReceipts(): Int

    fun setSumOfCommission(sumOfCommission: Double?)
    fun getSumOfCommission(): Double?
}