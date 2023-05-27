package me.ugreek85.document.common.impl

import me.ugreek85.document.common.IDocumentTaxRate
import me.ugreek85.storage.tax_rate.impl.TaxRateImpl
import kotlin.properties.Delegates

class DocumentTaxRateImpl : IDocumentTaxRate, TaxRateImpl() {

    private var mRow: Int = 1
    private var mTurnoverSum by Delegates.notNull<Double>()
    private var mSourceSum: Double? = null
    private var mSum by Delegates.notNull<Double>()

    override fun setRow(row: Int){
        mRow = row
    }

    override fun getRow() = mRow

    override fun setTurnoverSum(turnoverSum: Double) {
        mTurnoverSum = turnoverSum
    }

    override fun getTurnoverSum(): Double {
        return mTurnoverSum
    }

    override fun setSourceSum(sourceSum: Double?) {
        mSourceSum = sourceSum
    }

    override fun getSourceSum(): Double? {
        return mSourceSum
    }

    override fun setSum(sum: Double) {
        mSum = sum
    }

    override fun getSum(): Double {
        return mSum
    }
}