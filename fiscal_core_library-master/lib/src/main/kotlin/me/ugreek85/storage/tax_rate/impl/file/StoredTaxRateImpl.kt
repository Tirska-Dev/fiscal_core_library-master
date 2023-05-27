package me.ugreek85.storage.tax_rate.impl.file

import com.google.gson.annotations.SerializedName
import me.ugreek85.storage.tax_rate.IStoredTaxRate

class StoredTaxRateImpl : IStoredTaxRate {

    @SerializedName("id")
    private var id: Long = 0

    @SerializedName("letter")
    private var letter: String = ""

    @SerializedName("name")
    private var name: String = ""

    @SerializedName("type")
    private var type: Int = 0

    @SerializedName("percent")
    private var percent: Double = 0.0

    @SerializedName("sign")
    private var sign: Boolean = false

    override fun setLetter(letter: String) {
        this.letter = letter
    }

    override fun getLetter(): String {
        return letter
    }

    override fun setType(type: Int) {
        this.type = type
    }

    override fun getType(): Int {
        return type
    }

    override fun setPercent(percent: Double) {
        this.percent = percent
    }

    override fun getPercent(): Double {
        return percent
    }

    override fun setName(name: String) {
        this.name = name
    }

    override fun getName(): String {
        return name
    }

    override fun setSign(sign: Boolean) {
        this.sign = sign
    }

    override fun getSign(): Boolean {
        return sign
    }

    override fun getId(): Long {
        return id
    }

    override fun setId(id: Long) {
        this.id = id
    }
}