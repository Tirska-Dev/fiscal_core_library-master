package me.ugreek85.storage.register

interface IRegisterRecord {

    fun getRegistrarId(): Long
    fun setRegistrarId(registrarId: Long)

    fun getFiscalNumber(): String
    fun setFiscalNumber(fiscalNumber: String)

    fun getLocalNumber(): Long
    fun setLocalNumber(localNumber: Long)

    fun isCanceled(): Boolean
    fun setCanceled(canceled: Boolean)

    fun setKey(key: String)
    fun getKey(): String

    fun getValue(): Double
    fun setValue(value: Double)
}