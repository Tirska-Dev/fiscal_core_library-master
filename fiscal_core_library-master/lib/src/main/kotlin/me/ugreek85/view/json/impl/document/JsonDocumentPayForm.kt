package me.ugreek85.view.json.impl.document

import com.google.gson.annotations.SerializedName
import me.ugreek85.document.common.IDocumentPayForm
import me.ugreek85.document.common.impl.BaseRowImpl

open class JsonDocumentPayForm : IDocumentPayForm, JsonBaseRow() {

    @SerializedName("code")
    private lateinit var mCode: String

    @SerializedName("name")
    private lateinit var mName: String

    override fun setCode(code: String) {
        mCode = code
    }

    override fun getCode(): String {
        return mCode
    }

    override fun setName(name: String) {
        mName = name
    }

    override fun getName(): String {
        return mName
    }
}