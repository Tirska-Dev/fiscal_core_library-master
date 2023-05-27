package me.ugreek85.storage.offline_state

import me.ugreek85.storage.offline_session.IOfflineSessionStorage
import java.util.*

interface IOfflineState {

    fun getSeed(): String?
    fun setSeed(seed: String?)

    fun getSessionId(): String?
    fun setSessionId(sessionId: String?)

    fun getStartedAt(): Date?
    fun setStartedAt(startedAt: Date?)

    fun getProblemOnlineDocumentNumber(): Long?
    fun setProblemOnlineDocumentNumber(documentNumber: Long?)

    fun getProblemOnlineDocumentType(): String?
    fun setProblemOnlineDocumentType(documentType: String?)

    fun getProblemOnlineDocumentUid(): String?
    fun setProblemOnlineDocumentUid(documentUid: String?)

    fun documentAdded(documentTime: Date)
    fun getLastDocumentTime(): Date?
    fun getDocumentsCount(): Int
    fun getCurrentDuration(): Long

    fun isTimeOut(): Boolean
    fun isFull(): Boolean

    fun getLastDocumentHash(): String?
    fun setLastDocumentHash(lastDocumentHash: String?)

    fun getMaxDuration(): Long
    fun setMaxDuration(maxDuration: Long)

    fun isErrorDuringLastSend(): Boolean
    fun setErrorDuringLastSend(errorDuringLastSend: Boolean)

    fun isTrySendFinishOfflineDocument(): Boolean
    fun setTrySendFinishOfflineDocument(trySendFinishOfflineDocument: Boolean)

    fun setNextDocumentNumber(nextDocumentNumber: Long)
    fun getNextDocumentNumber(): Long
    fun increaseNextDocumentNumber()
}