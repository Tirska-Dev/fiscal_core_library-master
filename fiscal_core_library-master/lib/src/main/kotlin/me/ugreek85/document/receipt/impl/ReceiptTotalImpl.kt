package me.ugreek85.document.receipt.impl

import me.ugreek85.document.receipt.IReceiptTotal
import kotlin.properties.Delegates

class ReceiptTotalImpl : IReceiptTotal {

    private var mSum by Delegates.notNull<Double>()
    private var mDiscountSum: Double? = null
    private var mSumWithoutRounding: Double? = null
    private var mRoundingSum: Double? = null
    private var mCommissionSum: Double? = null
    private var mPawnSumIssued: Double? = null
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