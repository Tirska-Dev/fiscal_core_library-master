package me.ugreek85.storage.tax_rate

interface ITaxRate {

    fun setLetter(letter: String)
    fun getLetter(): String

    fun setType(type: Int)
    fun getType(): Int

    fun setPercent(percent: Double)
    fun getPercent(): Double

    fun setName(name: String)
    fun getName(): String

    fun setSign(sign: Boolean)
    fun getSign(): Boolean
}