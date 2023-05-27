package me.ugreek85.view.json.impl.receipt

import com.google.gson.annotations.SerializedName
import me.ugreek85.document.common.impl.BaseRowImpl
import me.ugreek85.document.receipt.IExciseLabel
import me.ugreek85.document.receipt.IReceiptProduct
import me.ugreek85.document.receipt.PawnMoneyDirection
import me.ugreek85.utils.DocumentCopyUtil
import me.ugreek85.view.json.impl.document.JsonBaseRow
import me.ugreek85.view.xml.impl.receipt.XmlExciseLabel
import org.simpleframework.xml.Element
import java.util.ArrayList

class JsonReceiptProduct : IReceiptProduct, JsonBaseRow() {

    @SerializedName("code")
    private var mCode: String? = null

    @SerializedName("barCode")
    private var mBarCode: String? = null

    @SerializedName("uktzed")
    private var mNationalCode: String? = null

    @SerializedName("name")
    private var mName: String? = null

    @SerializedName("description")
    private var mDescription: String? = null

    @SerializedName("unitCode")
    private var mUnitCode: String? = null

    @SerializedName("unitName")
    private var mUnitName: String? = null

    @SerializedName("amount")
    private var mAmount: Double? = null

    @SerializedName("price")
    private var mPrice: Double? = null

    @SerializedName("cost")
    private var mCost: Double? = null

    @SerializedName("taxRateLetters")
    private var mTaxRateLetters: String? = null

    @SerializedName("comment")
    private var mComment: String? = null

    @Transient
    private var mPawnMoneyDirection: PawnMoneyDirection? = null

    @SerializedName("discountSum")
    private var mDiscountSum: Double? = null

    @SerializedName("exciseLabels")
    private var mExciseLabels: List<JsonExciseLabel>? = null


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
            JsonExciseLabel()
        }
    }

    override fun getExciseLabels(): List<IExciseLabel>? {
        return mExciseLabels?.apply {
            forEachIndexed { index, item ->
                item.setRow(index + 1)
            }
        }
    }
}