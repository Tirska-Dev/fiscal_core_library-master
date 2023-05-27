package me.ugreek85.view.xml.impl.types

import java.math.BigDecimal
import java.math.RoundingMode

open class Decimal(
    private var precision: Int,
    private var value: BigDecimal
) {

    constructor(precision: Int): this(precision, BigDecimal.ZERO)
//    constructor(precision: Int, value: Double) : this(precision, BigDecimal.valueOf(value)) {
//    }


    fun getValue() = value

    fun setValue(value: BigDecimal){
        this.value = value
    }
    fun setValue(value: Double){
        this.value = BigDecimal.valueOf(value)
    }

    fun getFormattedValue(): String
    {
        return value.setScale(precision, RoundingMode.HALF_UP).toString()
    }

    override fun toString(): String
    {
        return getFormattedValue()
    }
}