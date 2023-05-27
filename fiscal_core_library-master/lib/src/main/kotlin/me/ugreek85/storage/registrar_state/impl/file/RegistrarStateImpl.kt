package me.ugreek85.storage.registrar_state.impl.file

import com.google.gson.annotations.SerializedName
import me.ugreek85.storage.common.PathAbility
import me.ugreek85.storage.offline_state.IOfflineState
import me.ugreek85.storage.offline_state.impl.file.OfflineStateImpl
import me.ugreek85.storage.registrar_state.IRegistrarState
import java.io.File

class RegistrarStateImpl(
    workingDirectory: File) : IRegistrarState, PathAbility(workingDirectory) {

    @SerializedName("registrarId")
    private var registrarId: Long = 0;

    @SerializedName("closed")
    private var closed: Boolean = false

    @SerializedName("offlineSupported")
    private var offlineSupported: Boolean = false;

    @SerializedName("offlineStarted")
    private var offlineStarted: Boolean = false;

    @SerializedName("shiftOpened")
    private var shiftOpened: Boolean = false

    @SerializedName("zReportSent")
    private var zReportSent: Boolean = false

    @SerializedName("nextDocumentNumber")
    private var nextDocumentNumber: Long = 1;

    @SerializedName("shiftId")
    private var shiftId: String? = null

    @SerializedName("offlineState")
    private val offlineState = OfflineStateImpl()


    override fun getRegistrarId(): Long {
        return registrarId
    }

    override fun setRegistrarId(registrarId: Long) {
        this.registrarId = registrarId
    }

    override fun isClosed(): Boolean {
        return closed
    }

    override fun setClosed(closed: Boolean) {
        this.closed = closed
    }

    override fun isOfflineSupported(): Boolean {
        return offlineSupported
    }

    override fun setOfflineSupported(offlineSupported: Boolean) {
        this.offlineSupported = offlineSupported
    }

    override fun isOfflineStarted(): Boolean {
        return offlineStarted
    }

    override fun setOfflineStarted(offlineStarted: Boolean) {
        this.offlineSupported = offlineStarted
    }

    override fun setNextDocumentNumber(nextDocumentNumber: Long) {
        this.nextDocumentNumber = nextDocumentNumber
    }

    override fun getNextDocumentNumber(): Long {
        return nextDocumentNumber
    }

    override fun increaseNextDocumentNumber() {
        ++nextDocumentNumber
        if(offlineStarted) offlineState.increaseNextDocumentNumber()
    }

    override fun isShiftOpened(): Boolean {
        return shiftOpened
    }

    override fun setShiftOpened(shiftOpened: Boolean) {
        this.shiftOpened = shiftOpened
    }

    override fun isZReportSent(): Boolean {
        return zReportSent
    }

    override fun setZReportSent(zReportSent: Boolean) {
        this.zReportSent = zReportSent
    }

    override fun getOfflineState(): IOfflineState {
        return offlineState
    }


    override fun getShiftId(): String? {
        return shiftId
    }

    override fun setShiftId(shiftId: String?) {
        this.shiftId = shiftId
    }

}