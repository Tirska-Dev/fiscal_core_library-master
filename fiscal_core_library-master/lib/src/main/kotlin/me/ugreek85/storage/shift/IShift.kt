package me.ugreek85.storage.shift

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

interface IShift {

    fun getRegistrarId(): Long
    fun setRegistrarId(registrarId: Long)

    fun getShiftId(): String
    fun setShiftId(shiftId: String)

    fun getOpenedAt(): Date
    fun setOpenedAt(date: Date)

    fun getCashierKeyIdThatOpenedShift(): String
    fun setCashierKeyIdThatOpenedShift(cashierKeyId: String)

    fun getClosedAt(): Date?
    fun setClosedAt(date: Date?)

    fun getCashierNameThatOpenedShift(): String
    fun setCashierNameThatOpenedShift(cashierName: String)

    fun getFiscalNumberOfZReportDocument(): String?
    fun setFiscalNumberOfZReportDocument(fiscalNumber: String?)

    fun getFiscalNumberOfCloseShiftDocument(): String?
    fun setFiscalNumberOfCloseShiftDocument(fiscalNumber: String?)

    fun getCashierKeyIdThatClosedShift(): String?
    fun setCashierKeyIdThatClosedShift(cashierKeyId: String?)

    fun getCashierNameThatClosedShift(): String?
    fun setCashierNameThatClosedShift(cashierName: String?)

    fun getIndexName(): String {
        return SimpleDateFormat("yyyyMMddHHmmss").format(getOpenedAt())
    }
}