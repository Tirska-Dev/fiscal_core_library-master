package me.ugreek85.storage.document_info.impl.file

import com.google.gson.annotations.SerializedName
import me.ugreek85.document.common.DocumentType
import me.ugreek85.storage.document_info.DocumentInfoState
import me.ugreek85.storage.document_info.IDocumentInfo
import java.util.*

class DocumentInfoImpl : IDocumentInfo {

    @SerializedName("date")
    private var date: Date = Date();

    @SerializedName("registrarId")
    private var registrarId: Long = 0;

    @SerializedName("localNumber")
    private var localNumber: Long = 0;

    @SerializedName("fiscalNumber")
    private var fiscalNumber: String? = null;

    @SerializedName("shiftId")
    private var shiftId: String? = null

    @SerializedName("documentType")
    private lateinit var documentType: DocumentType

    @SerializedName("revoked")
    private var revoked: Boolean = false

    @SerializedName("canceled")
    private var canceled: Boolean = false

    @SerializedName("state")
    private lateinit var state: DocumentInfoState

    @SerializedName("hash")
    private var hash: String? = null


    override fun getDate(): Date {
        return date
    }

    override fun setDate(date: Date) {
        this.date = date
    }

    override fun getRegistrarId(): Long {
        return registrarId
    }

    override fun setRegistrarId(registrarId: Long) {
        this.registrarId = registrarId
    }

    override fun getLocalNumber(): Long {
        return localNumber
    }

    override fun setLocalNumber(localNumber: Long) {
        this.localNumber = localNumber
    }

    override fun getFiscalNumber(): String? {
        return fiscalNumber
    }

    override fun setFiscalNumber(fiscalNumber: String?) {
        this.fiscalNumber = fiscalNumber
    }

    override fun getShiftId(): String? {
        return shiftId
    }

    override fun setShiftId(shiftId: String?) {
        this.shiftId = shiftId
    }

    override fun getDocumentType(): DocumentType {
        return documentType
    }

    override fun setDocumentType(documentType: DocumentType) {
        this.documentType = documentType
    }

    override fun isRevoked(): Boolean {
        return revoked
    }

    override fun setRevoked(revoked: Boolean) {
        this.revoked = revoked
    }

    override fun isCanceled(): Boolean {
        return canceled
    }

    override fun setCanceled(canceled: Boolean) {
        this.canceled = canceled
    }

    override fun getState(): DocumentInfoState {
        return state
    }

    override fun setState(state: DocumentInfoState) {
        this.state = state
    }

    override fun getHash(): String? {
        return hash
    }

    override fun setHash(hash: String?) {
        this.hash = hash
    }
}