package me.ugreek85.storage.registrar_info

interface IRegistrarInfo {

    fun getRegistrarId(): Long
    fun setRegistrarId(registrarId: Long)

    fun setRegistrarLocalNumber(registrarLocalNumber: Long)
    fun getRegistrarLocalNumber(): Long

    fun setCompanyName(companyName: String)
    fun getCompanyName(): String

    // TIN
    fun setSellerId(sellerId: String)
    fun getSellerId(): String

    // IPN
    fun setVatNumber(vatNumber: String?)
    fun getVatNumber(): String?

    fun setPointName(pointName: String)
    fun getPointName(): String

    fun setPointAddress(pointAddres: String)
    fun getPointAddress(): String

    fun setName(name: String?)
    fun getName(): String?
}