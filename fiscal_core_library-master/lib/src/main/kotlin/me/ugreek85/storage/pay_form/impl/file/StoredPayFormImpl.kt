package me.ugreek85.storage.pay_form.impl.file

import com.google.gson.annotations.SerializedName
import me.ugreek85.storage.pay_form.IStoredPayForm

class StoredPayFormImpl : IStoredPayForm {

    @SerializedName("id")
    private var id: Long = 0;

    @SerializedName("code")
    private var code: String = ""

    @SerializedName("name")
    private var name: String = ""

    override fun setCode(code: String) {
        this.code = code;
    }

    override fun getCode(): String {
        return code
    }

    override fun setName(name: String) {
        this.name = name;
    }

    override fun getName(): String {
        return name
    }

    override fun getId(): Long {
        return id
    }

    override fun setId(id: Long) {
        this.id = id
    }
}