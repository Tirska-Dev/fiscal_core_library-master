package me.ugreek85.view.json.impl.receipt

import com.google.gson.annotations.SerializedName
import me.ugreek85.document.receipt.IReceiptTotal
import kotlin.properties.Delegates

class JsonReceiptTotal : IReceiptTotal {

    @SerializedName("sum")
    private var mSum: Double = 0.0;

    @SerializedName("discountSum")
    private var mDiscountSum: Double? = null

    @SerializedName("sumWithoutRounding")
    private var mSumWithoutRounding: Double? = null

    @SerializedName("roundingSum")
    private var mRoundingSum: Double? = null

    @SerializedName("commissionSum")
    private var mCommissionSum: Double? = null

    @Transient
    private var mPawnSumIssued: Double? = null

    @Transient
    private var mPawnSumReceived: Double? = null

    override fun setSum(sum: Double) {
        mSum = sum
    }

    override fun getSum(): Double {
        return mSum
    }

    override fun setPawnSumIssued(pawnSumIssued: Double?) {
        mPawnSumIssued = pawnSumIssued;
    }

    override fun getPawnSumIssued(): Double? {
        return mPawnSumIssued
    }

    override fun setPawnSumReceived(pawnSumReceived: Double?) {
        mPawnSumReceived = pawnSumReceived
    }

    override fun getPawnSumReceived(): Double? {
        return mPawnSumReceived
    }

    override fun setDiscountSum(discountSum: Double?) {
        mDiscountSum = discountSum
    }

    override fun getDiscountSum(): Double? {
        return mDiscountSum
    }

    override fun setSumWithoutRounding(sumWithoutRounding: Double?) {
        mSumWithoutRounding = sumWithoutRounding
    }

    override fun getSumWithoutRounding(): Double? {
        return mSumWithoutRounding
    }

    override fun setRoundingSum(roundingSum: Double?) {
        mRoundingSum = roundingSum
    }

    override fun getRoundingSum(): Double? {
        return mRoundingSum
    }

    override fun setCommissionSum(commissionSum: Double?) {
        mCommissionSum = commissionSum
    }

    override fun getCommissionSum(): Double? {
        return mCommissionSum
    }
}