package me.ugreek85.storage.tax_rate.impl

import me.ugreek85.storage.tax_rate.ITaxRate
import kotlin.properties.Delegates

open class TaxRateImpl : ITaxRate {

    private lateinit var mLetter: String
    private var mType by Delegates.notNull<Int>()
    private var mPercent by Delegates.notNull<Double>()
    private lateinit var mName: String
    private var mSign by Delegates.notNull<Boolean>()

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
        mPercent = percent
    }

    override fun getPercent(): Double {
        return mPercent
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
}