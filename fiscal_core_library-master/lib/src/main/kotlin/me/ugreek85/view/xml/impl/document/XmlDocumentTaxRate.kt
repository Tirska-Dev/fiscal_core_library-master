package me.ugreek85.view.xml.impl.document

import me.ugreek85.document.common.IDocumentTaxRate
import me.ugreek85.view.xml.impl.types.Decimal2
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "ROW")
class XmlDocumentTaxRate : IDocumentTaxRate, XmlBaseRow() {

    @field:Element(name="TYPE")
    private var mType: Int = 0

    @field:Element(name="NAME")
    private var mName: String = ""

    @field:Element(name="LETTER")
    private var mLetter: String = ""

    @field:Element(name="PRC")
    private var mPercent: Decimal2 = Decimal2()

    @field:Element(name="SIGN", required = false)
    private var mSign: Boolean = false

    @field:Element(name="TURNOVER")
    private var mTurnoverSum: Decimal2 = Decimal2()

    @field:Element(name="SOURCESUM", required = false)
    private var mSourceSum: Decimal2? = null

    @field:Element(name="SUM")
    private var mSum: Decimal2 = Decimal2()

    override fun setTurnoverSum(turnoverSum: Double) {
        mTurnoverSum.setValue(turnoverSum)
    }

    override fun getTurnoverSum(): Double {
        return mTurnoverSum.getValue().toDouble()
    }

    override fun setSourceSum(sourceSum: Double?) {
        mSourceSum = if (sourceSum == null) null
        else {
            Decimal2().apply { setValue(sourceSum) }
        }
    }

    override fun getSourceSum(): Double? {
        return if (mSourceSum == null) null else mSourceSum!!.getValue().toDouble()
    }

    override fun setSum(sum: Double) {
        mSum.setValue(sum)
    }

    override fun getSum(): Double {
        return mSum.getValue().toDouble()
    }

    override fun setLetter(letter: String) {
        mLetter = letter
    }

    override fun getLetter(): String {
        return mLetter
    }

    override fun setType(type: Int) {
        mType = type
    }

    override fun getType(): Int {
        return mType
    }

    override fun setPercent(percent: Double) {
        mPercent.setValue(percent)
    }

    override fun getPercent(): Double {
        return mPercent.getValue().toDouble()
    }

    override fun setName(name: String) {
        mName = name
    }

    override fun getName(): String {
        return mName
    }

    override fun setSign(sign: Boolean) {
        mSign = sign
    }

    override fun getSign(): Boolean {
        return mSign
    }

    override fun toString(): String {
        return "XmlDocumentTaxRate(mRow=${getRow()}, mType=$mType, mName='$mName', mLetter='$mLetter', mPercent=$mPercent, mSign=$mSign, mTurnoverSum=$mTurnoverSum, mSourceSum=$mSourceSum, mSum=$mSum)"
    }
}