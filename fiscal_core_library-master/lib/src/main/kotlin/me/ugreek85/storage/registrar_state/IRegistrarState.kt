package me.ugreek85.storage.registrar_state

import me.ugreek85.storage.offline_state.IOfflineState
import me.ugreek85.storage.shift.IShift

interface IRegistrarState {

    fun getRegistrarId(): Long
    fun setRegistrarId(registrarId: Long)

    fun isClosed(): Boolean
    fun setClosed(closed: Boolean)

    fun isOfflineSupported(): Boolean
    fun setOfflineSupported(offlineSupported: Boolean)

    fun isOfflineStarted(): Boolean
    fun setOfflineStarted(offlineStarted: Boolean)

    fun setNextDocumentNumber(nextDocumentNumber: Long)
    fun getNextDocumentNumber(): Long
    fun increaseNextDocumentNumber()

    fun isShiftOpened(): Boolean
    fun setShiftOpened(shiftOpened: Boolean)

    fun isZReportSent(): Boolean
    fun setZReportSent(zReportSent: Boolean)

    fun getOfflineState(): IOfflineState

    fun getShiftId(): String?
    fun setShiftId(shiftId: String?)
}