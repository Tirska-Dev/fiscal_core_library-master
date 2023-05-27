package me.ugreek85.document.common

import me.ugreek85.storage.tax_rate.ITaxRate

interface IDocumentTaxRate : ITaxRate, IRow {

    fun setTurnoverSum(turnoverSum: Double)
    fun getTurnoverSum(): Double

    fun setSourceSum(sourceSum: Double?)
    fun getSourceSum(): Double?

    fun setSum(sum: Double)
    fun getSum(): Double
}