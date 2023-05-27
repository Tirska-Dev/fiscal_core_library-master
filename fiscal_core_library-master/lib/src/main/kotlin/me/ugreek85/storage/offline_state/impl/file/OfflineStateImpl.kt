package me.ugreek85.storage.offline_state.impl.file

import com.google.gson.annotations.SerializedName
import me.ugreek85.storage.offline_state.IOfflineState
import java.util.*
import java.util.concurrent.TimeUnit

class OfflineStateImpl : IOfflineState {

    @Transient
    private val MAX_DOCUMENTS_COUNT = 2000;

    @SerializedName("seed")
    private var seed: String? = null

    @SerializedName("sessionId")
    private var sessionId: String? = null

    @SerializedName("startedAt")
    private var startedAt: Date? = null

    @SerializedName("problemOnlineDocumentNumber")
    private var problemOnlineDocumentNumber: Long? = null

    @SerializedName("problemOnlineDocumentType")
    private var problemOnlineDocumentType: String? = null

    @SerializedName("problemOnlineDocumentUid")
    private var problemOnlineDocumentUid: String? = null

    @SerializedName("nextDocumentNumber")
    private var nextDocumentNumber: Long = 1;

    @SerializedName("lastDocumentHash")
    private var lastDocumentHash: String? = null

    @SerializedName("lastDocumentTime")
    private var lastDocumentTime: Date? = null

    @SerializedName("documentsCount")
    private var documentsCount: Int = 0;

    @SerializedName("maxDuration")
    private var maxDuration: Long = TimeUnit.HOURS.toMillis(36)

    @SerializedName("errorDuringLastSend")
    private var errorDuringLastSend: Boolean = false

    @SerializedName("trySendFinishOfflineDocument")
    private var trySendFinishOfflineDocument: Boolean = false

    override fun getSeed(): String? {
        return seed
    }

    override fun setSeed(seed: String?) {
        this.seed = seed
    }

    override fun getSessionId(): String? {
        return sessionId
    }

    override fun setSessionId(sessionId: String?) {
        this.sessionId = sessionId
    }

    override fun getStartedAt(): Date? {
        return startedAt
    }

    override fun setStartedAt(startedAt: Date?) {
        this.startedAt = startedAt
    }

    override fun getProblemOnlineDocumentNumber(): Long? {
        return problemOnlineDocumentNumber
    }

    override fun setProblemOnlineDocumentNumber(documentNumber: Long?) {
        this.problemOnlineDocumentNumber = documentNumber
    }

    override fun getProblemOnlineDocumentType(): String? {
        return problemOnlineDocumentType
    }

    override fun setProblemOnlineDocumentType(documentType: String?) {
        this.problemOnlineDocumentType = documentType
    }

    override fun getProblemOnlineDocumentUid(): String? {
        return problemOnlineDocumentUid
    }

    override fun setProblemOnlineDocumentUid(documentUid: String?) {
        this.problemOnlineDocumentUid = documentUid
    }

    override fun documentAdded(documentTime: Date) {
        this.lastDocumentTime = documentTime
        ++documentsCount
    }

    override fun getLastDocumentTime(): Date? {
        return lastDocumentTime
    }

    override fun getCurrentDuration(): Long {
        if(startedAt == null) return 0L
        return Date().time - startedAt!!.time
    }

    override fun isTimeOut(): Boolean {
        return getCurrentDuration() > getMaxDuration()
    }

    override fun isFull(): Boolean {
        return documentsCount == MAX_DOCUMENTS_COUNT - 1
    }

    override fun getDocumentsCount(): Int {
        return documentsCount
    }

    override fun getLastDocumentHash(): String? {
        return lastDocumentHash
    }

    override fun setLastDocumentHash(lastDocumentHash: String?) {
        this.lastDocumentHash = lastDocumentHash
    }

    override fun getMaxDuration(): Long {
        return maxDuration
    }

    override fun setMaxDuration(maxDuration: Long) {
        this.maxDuration = maxDuration
    }

    override fun isErrorDuringLastSend(): Boolean {
        return errorDuringLastSend
    }

    override fun setErrorDuringLastSend(errorDuringLastSend: Boolean) {
        this.errorDuringLastSend = errorDuringLastSend
    }

    override fun isTrySendFinishOfflineDocument(): Boolean {
        return trySendFinishOfflineDocument
    }

    override fun setTrySendFinishOfflineDocument(trySendFinishOfflineDocument: Boolean) {
        this.trySendFinishOfflineDocument = trySendFinishOfflineDocument
    }

    override fun setNextDocumentNumber(nextDocumentNumber: Long) {
        this.nextDocumentNumber = nextDocumentNumber
    }

    override fun getNextDocumentNumber(): Long {
        return this.nextDocumentNumber
    }

    override fun increaseNextDocumentNumber() {
        ++nextDocumentNumber
    }
}