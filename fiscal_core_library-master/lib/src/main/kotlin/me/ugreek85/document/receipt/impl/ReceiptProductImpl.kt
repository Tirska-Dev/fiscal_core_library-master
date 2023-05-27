package me.ugreek85.document.receipt.impl

import me.ugreek85.builder.document.base.IReceiptDocumentFactoriesSet
import me.ugreek85.document.common.impl.BaseRowImpl
import me.ugreek85.document.receipt.IExciseLabel
import me.ugreek85.document.receipt.IReceiptProduct
import me.ugreek85.document.receipt.PawnMoneyDirection
import me.ugreek85.utils.DocumentCopyUtil

class ReceiptProductImpl(
    private val mReceiptDocumentFactoriesSet: IReceiptDocumentFactoriesSet? = null
) : IReceiptProduct, BaseRowImpl() {

    private var mCode: String? = null
    private var mBarCode: String? = null
    private var mNationalCode: String? = null
    private var mName: String? = null
    private var mDescription: String? = null
    private var mUnitCode: String? = null
    private var mUnitName: String? = null
    private var mAmount: Double? = null
    private var mPrice: Double? = null
    private var mCost: Double? = null
    private var mTaxRateLetters: String? = null
    private var mComment: String? = null
    private var mPawnMoneyDirection: PawnMoneyDirection? = null
    private var mDiscountSum: Double? = null
    private var mExciseLabels: List<IExciseLabel>? = null


    override fun setCode(code: String?) {
        mCode = code
    }

    override fun getCode(): String? {
        return mCode
    }

    override fun setBarCode(barCode: String?) {
        mBarCode = barCode
    }

    override fun getBarCode(): String? {
        return mBarCode
    }

    override fun setNationalCode(nationalCode: String?) {
        mNationalCode = nationalCode
    }

    override fun getNationalCode(): String? {
        return mNationalCode
    }

    override fun setName(name: String?) {
        mName = name
    }

    override fun getName(): String? {
        return mName
    }

    override fun setDescription(description: String?) {
        mDescription = description
    }

    override fun getDescription(): String? {
        return mDescription
    }

    override fun setUnitCode(unitCode: String?) {
        mUnitCode = unitCode
    }

    override fun getUnitCode(): String? {
        return mUnitCode
    }

    override fun setUnitName(unitName: String?) {
        mUnitName = unitName
    }

    override fun getUnitName(): String? {
        return mUnitName
    }

    override fun setAmount(amount: Double?) {
        mAmount = amount
    }

    override fun getAmount(): Double? {
        return mAmount
    }

    override fun setPrice(price: Double?) {
        mPrice = price
    }

    override fun getPrice(): Double? {
        return mPrice
    }

    override fun setTaxRateLetter(taxRateLetter: String?) {
        mTaxRateLetters = taxRateLetter
    }

    override fun getTaxRateLetter(): String? {
        return mTaxRateLetters
    }

    override fun setCost(cost: Double?) {
        mCost = cost
    }

    override fun getCost(): Double? {
        return mCost
    }

    override fun setComment(comment: String?) {
        mComment = comment
    }

    override fun getComment(): String? {
        return mComment
    }

    override fun getPawnMoneyDirection(): PawnMoneyDirection? {
        return mPawnMoneyDirection
    }

    override fun setPawnMoneyDirection(pawnMoneyDirection: PawnMoneyDirection?) {
        mPawnMoneyDirection = pawnMoneyDirection
    }

    override fun setDiscountSum(discountSum: Double?) {
        mDiscountSum = discountSum
    }

    override fun getDiscountSum(): Double? {
        return mDiscountSum
    }

    override fun setExciseLabels(exciseLabels: List<IExciseLabel>?) {
        mExciseLabels = DocumentCopyUtil.copyList(IExciseLabel::class.java, exciseLabels){
            mReceiptDocumentFactoriesSet?.newExciseLabel() ?: ExciseLabelImpl()
        }
    }

    override fun getExciseLabels(): List<IExciseLabel>? {
        return mExciseLabels
    }
}