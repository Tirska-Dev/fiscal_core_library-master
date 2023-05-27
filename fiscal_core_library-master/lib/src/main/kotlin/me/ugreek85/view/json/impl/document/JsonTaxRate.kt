package me.ugreek85.view.json.impl.document

import com.google.gson.annotations.SerializedName
import me.ugreek85.storage.tax_rate.ITaxRate
import kotlin.properties.Delegates

open class JsonTaxRate : ITaxRate {

    @SerializedName("letter")
    private var mLetter: String = ""
    @SerializedName("type")
    private var mType: Int = 0

    @SerializedName("percent")
    private var mPercent: Double = 0.0

    @SerializedName("name")
    private var mName: String = ""

    @SerializedName("sign")
    private var mSign: Boolean = false

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