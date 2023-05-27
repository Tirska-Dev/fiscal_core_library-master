package me.ugreek85.storage.registrar_info

import com.google.gson.annotations.SerializedName

class RegistrarInfoImpl : IRegistrarInfo {

    @SerializedName("registrarId")
    private var registrarId: Long = 0;

    @SerializedName("registrarLocalNumber")
    private var registrarLocalNumber: Long = 0;

    @SerializedName("companyName")
    private var companyName: String = ""

    @SerializedName("pointName")
    private var pointName: String = ""

    @SerializedName("pointAddress")
    private var pointAddress: String = ""

    @SerializedName("sellerId")
    private var sellerId: String = ""

    @SerializedName("vatNumber")
    private var vatNumber: String? = null

    @SerializedName("name")
    private var name: String? = null

    override fun getRegistrarId(): Long {
        return registrarId
    }

    override fun setRegistrarId(registrarId: Long) {
        this.registrarId = registrarId
    }

    override fun setRegistrarLocalNumber(registrarLocalNumber: Long) {
        this.registrarLocalNumber = registrarLocalNumber
    }

    override fun getRegistrarLocalNumber(): Long {
        return registrarLocalNumber
    }

    override fun setCompanyName(companyName: String) {
        this.companyName = companyName
    }

    override fun getCompanyName(): String {
        return this.companyName
    }

    override fun setSellerId(sellerId: String) {
        this.sellerId = sellerId
    }

    override fun getSellerId(): String {
        return sellerId
    }

    override fun setVatNumber(vatNumber: String?) {
        this.vatNumber = vatNumber
    }

    override fun getVatNumber(): String? {
        return vatNumber
    }

    override fun setPointName(pointName: String) {
        this.pointName = pointName
    }

    override fun getPointName(): String {
        return pointName
    }

    override fun setPointAddress(pointAddress: String) {
        this.pointAddress = pointAddress
    }

    override fun getPointAddress(): String {
        return pointAddress
    }

    override fun setName(name: String?) {
        this.name = name
    }

    override fun getName(): String? {
        return name
    }
}