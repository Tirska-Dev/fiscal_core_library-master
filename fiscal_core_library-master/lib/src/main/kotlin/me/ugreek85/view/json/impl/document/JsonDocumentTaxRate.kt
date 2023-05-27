package me.ugreek85.view.json.impl.document

import com.google.gson.annotations.SerializedName
import me.ugreek85.document.common.IDocumentTaxRate
import me.ugreek85.storage.tax_rate.impl.TaxRateImpl

class JsonDocumentTaxRate : IDocumentTaxRate, JsonTaxRate() {

    @Transient
    private var mRow: Int = 1

    @SerializedName("turnoverSum")
    private var mTurnoverSum: Double = 0.0

    @SerializedName("sourceSum")
    private var mSourceSum: Double? = null

    @SerializedName("sum")
    private var mSum: Double = 0.0

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