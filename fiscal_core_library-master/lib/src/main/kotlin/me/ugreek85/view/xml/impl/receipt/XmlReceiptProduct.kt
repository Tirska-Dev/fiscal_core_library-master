package me.ugreek85.view.xml.impl.receipt

import me.ugreek85.document.receipt.IExciseLabel
import me.ugreek85.document.receipt.IReceiptPayForm
import me.ugreek85.document.receipt.IReceiptProduct
import me.ugreek85.document.receipt.PawnMoneyDirection
import me.ugreek85.utils.DocumentCopyUtil
import me.ugreek85.view.xml.impl.document.XmlBaseRow
import me.ugreek85.view.xml.impl.types.Decimal2
import me.ugreek85.view.xml.impl.types.Decimal3
import me.ugreek85.view.xml.impl.util.DecimalUtil
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.util.ArrayList

@Root(name = "ROW")
class XmlReceiptProduct : IReceiptProduct, XmlBaseRow() {

    @field:Element(name="CODE", required = false)
    private var mCode: String? = null

    @field:Element(name="BARCODE", required = false)
    private var mBarCode: String? = null

    @field:Element(name="UKTZED", required = false)
    private var mNationalCode: String? = null

    @field:Element(name="NAME", required = false)
    private var mName: String? = null

    @field:Element(name="DESCRIPTION", required = false)
    private var mDescription: String? = null

    @field:Element(name="UNITCD", required = false)
    private var mUnitCode: String? = null

    @field:Element(name="UNITNM", required = false)
    private var mUnitName: String? = null

    @field:Element(name="AMOUNT", required = false)
    private var mAmount: Decimal3? = null

    @field:Element(name="PRICE", required = false)
    private var mPrice: Decimal2? = null

    @field:Element(name="LETTERS", required = false)
    private var mTaxRateLetters: String? = null

    @field:Element(name="COST", required = false)
    private var mCost: Decimal2? = null

    @field:Element(name="PWNDIR", required = false)
    var mPawnMoneyDirection: PawnMoneyDirection? = null

    @field:Element(name="DISCOUNTSUM", required = false)
    private var mDiscountSum: Decimal2? = null

    @field:Element(name="COMMENT", required = false)
    private var mComment: String? = null

    @field:ElementList(name="EXCISELABELS", required = false)
    private var mExciseLabels: ArrayList<XmlExciseLabel>? = null

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
        mAmount = DecimalUtil.create(amount)
    }

    override fun getAmount(): Double? {
        return DecimalUtil.getDoubleValue(mAmount)
    }

    override fun setPrice(price: Double?) {
        mPrice = DecimalUtil.create(price)
    }

    override fun getPrice(): Double? {
        return DecimalUtil.getDoubleValue(mPrice)
    }

    override fun setTaxRateLetter(taxRateLetter: String?) {
        mTaxRateLetters = taxRateLetter
    }

    override fun getTaxRateLetter(): String? {
        return mTaxRateLetters
    }

    override fun setCost(cost: Double?) {
        mCost = DecimalUtil.create(cost)
    }

    override fun getCost(): Double? {
        return DecimalUtil.getDoubleValue(mCost)
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
        mDiscountSum = DecimalUtil.create(discountSum)
    }

    override fun getDiscountSum(): Double? {
        return DecimalUtil.getDoubleValue(mDiscountSum)
    }

    override fun setExciseLabels(exciseLabels: List<IExciseLabel>?) {
        mExciseLabels = DocumentCopyUtil.copyArrayList(IExciseLabel::class.java, exciseLabels){
            XmlExciseLabel()
        }
    }

    override fun getExciseLabels(): List<IExciseLabel>? {
        return mExciseLabels
    }

    override fun toString(): String {
        return "XmlReceiptProduct(mCode=$mCode, mBarCode=$mBarCode, mNationalCode=$mNationalCode, mName=$mName, mDescription=$mDescription, mUnitCode=$mUnitCode, mUnitName=$mUnitName, mAmount=$mAmount, mPrice=$mPrice, mTaxRateLetters=$mTaxRateLetters, mCost=$mCost, mPawnMoneyDirection=$mPawnMoneyDirection, mDiscountSum=$mDiscountSum, mComment=$mComment, mExciseLabels=$mExciseLabels)"
    }

}