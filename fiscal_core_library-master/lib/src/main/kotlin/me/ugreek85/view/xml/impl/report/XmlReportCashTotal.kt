package me.ugreek85.view.xml.impl.report

import me.ugreek85.document.report.IReportCashTotal
import me.ugreek85.view.xml.impl.types.Decimal2
import me.ugreek85.view.xml.impl.util.DecimalUtil
import org.simpleframework.xml.Element


class XmlReportCashTotal : IReportCashTotal {

    @field:Element(name="SUM")
    private var mSum = Decimal2()

    @field:Element(name="COMMISSION", required = false)
    private var mSumOfCommission: Decimal2? = null

    @field:Element(name="ORDERSCNT")
    private var mNumberOfReceipts: Int = 0


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

    override fun setSumOfCommission(sumOfCommission: Double?) {
        mSumOfCommission = DecimalUtil.create(sumOfCommission)
    }

    override fun getSumOfCommission(): Double? {
        return DecimalUtil.getDoubleValue(mSumOfCommission)
    }

    override fun toString(): String {
        return "XmlReportCashTotal(mSum=$mSum, mSumOfCommission=$mSumOfCommission, mNumberOfReceipts=$mNumberOfReceipts)"
    }
}