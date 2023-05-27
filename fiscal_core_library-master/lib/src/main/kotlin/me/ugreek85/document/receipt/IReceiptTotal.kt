package me.ugreek85.document.receipt

interface IReceiptTotal {

    fun setSum(sum: Double)
    fun getSum(): Double

    fun setPawnSumIssued(pawnSumIssued: Double?)
    fun getPawnSumIssued(): Double?

    fun setPawnSumReceived(pawnSumReceived: Double?)
    fun getPawnSumReceived(): Double?

    fun setDiscountSum(discountSum: Double?)
    fun getDiscountSum(): Double?

    fun setSumWithoutRounding(sumWithoutRounding: Double?)
    fun getSumWithoutRounding(): Double?

    fun setRoundingSum(roundingSum: Double?)
    fun getRoundingSum(): Double?

    fun setCommissionSum(commissionSum: Double?)
    fun getCommissionSum(): Double?
}