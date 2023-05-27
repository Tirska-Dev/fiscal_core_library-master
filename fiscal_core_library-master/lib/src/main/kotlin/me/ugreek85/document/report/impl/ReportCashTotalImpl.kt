package me.ugreek85.document.report.impl

import me.ugreek85.document.report.IReportCashTotal
import kotlin.properties.Delegates

class ReportCashTotalImpl : IReportCashTotal {

    private var mSum by Delegates.notNull<Double>()
    private var mNumberOfReceipts by Delegates.notNull<Int>()
    private var mSumOfCommission: Double? = null

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

    override fun setSumOfCommission(sumOfCommission: Double?) {
        mSumOfCommission = sumOfCommission
    }

    override fun getSumOfCommission(): Double? {
        return mSumOfCommission
    }

}