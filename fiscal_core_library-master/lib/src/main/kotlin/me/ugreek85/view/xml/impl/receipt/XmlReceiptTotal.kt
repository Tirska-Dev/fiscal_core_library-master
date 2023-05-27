package me.ugreek85.view.xml.impl.receipt

import me.ugreek85.document.receipt.IReceiptTotal
import me.ugreek85.view.xml.impl.types.Decimal2
import me.ugreek85.view.xml.impl.util.DecimalUtil
import org.simpleframework.xml.Element

class XmlReceiptTotal : IReceiptTotal {

    @field:Element(name="SUM")
    private var mSum: Decimal2 = Decimal2()

    @field:Element(name="PWNSUMISSUED", required = false)
    var mPawnSumIssued: Decimal2? = null

    @field:Element(name="PWNSUMRECEIVED", required = false)
    var mPawnSumReceived: Decimal2? = null

    @field:Element(name="RNDSUM", required = false)
    private var mRoundingSum: Decimal2? = null

    @field:Element(name="NORNDSUM", required = false)
    private var mSumWithoutRounding: Decimal2? = null

    @field:Element(name = "COMMISSION", required = false)
    var mCommissionSum: Decimal2? = null

    @field:Element(name="DISCOUNTSUM", required = false)
    private var mDiscountSum: Decimal2? = null


    override fun setSum(sum: Double) {
        mSum.setValue(sum)
    }

    override fun getSum(): Double {
        return mSum.getValue().toDouble()
    }

    override fun setPawnSumIssued(pawnSumIssued: Double?) {
        mPawnSumIssued = DecimalUtil.create(pawnSumIssued)
    }

    override fun getPawnSumIssued(): Double? {
        return DecimalUtil.getDoubleValue(mPawnSumIssued)
    }

    override fun setPawnSumReceived(pawnSumReceived: Double?) {
        mPawnSumReceived = DecimalUtil.create(pawnSumReceived)
    }

    override fun getPawnSumReceived(): Double? {
        return DecimalUtil.getDoubleValue(mPawnSumReceived)
    }

    override fun setDiscountSum(discountSum: Double?) {
        mDiscountSum = DecimalUtil.create(discountSum)
    }

    override fun getDiscountSum(): Double? {
        return DecimalUtil.getDoubleValue(mDiscountSum)
    }

    override fun setSumWithoutRounding(sumWithoutRounding: Double?) {
        mSumWithoutRounding = DecimalUtil.create(sumWithoutRounding)
    }

    override fun getSumWithoutRounding(): Double? {
        return DecimalUtil.getDoubleValue(mSumWithoutRounding)
    }

    override fun setRoundingSum(roundingSum: Double?) {
        mRoundingSum = DecimalUtil.create(roundingSum)
    }

    override fun getRoundingSum(): Double? {
        return DecimalUtil.getDoubleValue(mRoundingSum)
    }

    override fun setCommissionSum(commissionSum: Double?) {
        mCommissionSum = DecimalUtil.create(commissionSum)
    }

    override fun getCommissionSum(): Double? {
        return DecimalUtil.getDoubleValue(mCommissionSum)
    }

    override fun toString(): String {
        return "XmlReceiptTotal(mSum=$mSum, mRoundingSum=$mRoundingSum, mSumWithoutRounding=$mSumWithoutRounding, mCommissionSum=$mCommissionSum, mDiscountSum=$mDiscountSum)"
    }

}