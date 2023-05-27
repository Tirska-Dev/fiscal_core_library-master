package me.ugreek85.storage.shift.impl.file

import com.google.gson.annotations.SerializedName
import me.ugreek85.storage.shift.IShift
import java.util.*

class ShiftFileImpl : IShift {

    @SerializedName("registrarId")
    private var registrarId: Long = 0L

    @SerializedName("shiftId")
    private var shiftId: String = ""

    @SerializedName("openedAt")
    private var openedAt: Date = Date()

    @SerializedName("closedAt")
    private var closedAt: Date? = null

    @SerializedName("cashierKeyIdThatOpenedShift")
    private var cashierKeyIdThatOpenedShift: String = ""

    @SerializedName("cashierNameThatOpenedShift")
    private var cashierNameThatOpenedShift: String = ""

    @SerializedName("cashierKeyIdThatClosedShift")
    private var cashierKeyIdThatClosedShift: String? = null

    @SerializedName("cashierNameThatClosedShift")
    private var cashierNameThatClosedShift: String? = null

    @SerializedName("fiscalNumberOfZReportDocument")
    private var fiscalNumberOfZReportDocument: String? = null

    @SerializedName("fiscalNumberOfCloseShiftDocument")
    private var fiscalNumberOfCloseShiftDocument: String? = null


    override fun getRegistrarId(): Long {
        return registrarId
    }

    override fun setRegistrarId(registrarId: Long) {
        this.registrarId = registrarId
    }

    override fun getShiftId(): String {
        return shiftId
    }

    override fun setShiftId(shiftId: String) {
        this.shiftId = shiftId
    }

    override fun getOpenedAt(): Date {
        return openedAt
    }

    override fun setOpenedAt(date: Date) {
        this.openedAt = date
    }

    override fun getCashierKeyIdThatOpenedShift(): String {
        return cashierKeyIdThatOpenedShift
    }

    override fun setCashierKeyIdThatOpenedShift(cashierKeyId: String) {
        cashierKeyIdThatOpenedShift = cashierKeyId
    }

    override fun getClosedAt(): Date? {
        return closedAt
    }

    override fun setClosedAt(date: Date?) {
        this.closedAt = date
    }

    override fun getCashierNameThatOpenedShift(): String {
        return cashierNameThatOpenedShift
    }

    override fun setCashierNameThatOpenedShift(cashierName: String) {
        this.cashierNameThatOpenedShift = cashierName
    }

    override fun getFiscalNumberOfZReportDocument(): String? {
        return fiscalNumberOfZReportDocument
    }

    override fun setFiscalNumberOfZReportDocument(fiscalNumber: String?) {
        this.fiscalNumberOfZReportDocument = fiscalNumber
    }

    override fun getFiscalNumberOfCloseShiftDocument(): String? {
        return fiscalNumberOfCloseShiftDocument
    }

    override fun setFiscalNumberOfCloseShiftDocument(fiscalNumber: String?) {
        this.fiscalNumberOfCloseShiftDocument = fiscalNumber
    }

    override fun getCashierKeyIdThatClosedShift(): String? {
        return cashierKeyIdThatClosedShift
    }

    override fun setCashierKeyIdThatClosedShift(cashierKeyId: String?) {
        this.cashierNameThatClosedShift = cashierKeyId
    }

    override fun getCashierNameThatClosedShift(): String? {
        return cashierNameThatClosedShift
    }

    override fun setCashierNameThatClosedShift(cashierName: String?) {
        this.cashierNameThatClosedShift = cashierName
    }
}