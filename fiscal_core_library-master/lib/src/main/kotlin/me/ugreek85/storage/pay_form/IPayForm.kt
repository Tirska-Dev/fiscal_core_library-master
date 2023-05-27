package me.ugreek85.storage.pay_form



interface IPayForm {

    fun setCode(code: String)
    fun getCode(): String

    fun setName(name: String)
    fun getName(): String
}