package me.ugreek85.storage.offline_session.impl.file

import me.ugreek85.storage.common.IDocumentAbility
import me.ugreek85.storage.common.PathAbility
import me.ugreek85.storage.common.SerializeUtil
import me.ugreek85.storage.document_info.IDocumentInfo
import me.ugreek85.storage.document_info.impl.file.DocumentInfoImpl
import me.ugreek85.storage.offline_session.IOfflineSessionStorage
import me.ugreek85.storage.stored_document.IStoredDocument
import me.ugreek85.storage.stored_document.IStoredDocumentStorage
import java.io.File
import java.nio.file.Files

class OfflineSessionStorageImpl(
    workingDirectory: File,
    private val documentStorage: IStoredDocumentStorage
) :
    IOfflineSessionStorage,
    PathAbility(workingDirectory), IDocumentAbility {


    private fun getOfflineDocuments(registrarId: Long): Array<File>
    {
        return getDocuments(getRootPathForOfflineDocuments(registrarId))
    }

    override fun getAll(registrarId: Long): List<IDocumentInfo> {
        return getOfflineDocuments(registrarId).map { SerializeUtil.load<DocumentInfoImpl>(it) }
    }

    override fun count(registrarId: Long): Int {
        return getOfflineDocuments(registrarId).size
    }

    override fun deleteByLocalNumber(registrarId: Long, localNumber: Long) {
        val documentFile = File(getRootPathForOfflineDocuments(registrarId), localNumber.toString())
        Files.delete(documentFile.toPath())
    }

    override fun getLastDocumentHash(registrarId: Long): String? {
        val files = getOfflineDocuments(registrarId)
        if(files.isEmpty()) return null
        val storedDocument = documentStorage.get(registrarId, files.last().name.toLong()) ?: return null
        return storedDocument.getHash()
    }

    override fun getFirstStoredDocument(registrarId: Long): IStoredDocument? {
        val files = getOfflineDocuments(registrarId)
        if(files.isEmpty()) return null
        return documentStorage.get(registrarId, files.first().name.toLong())
    }

    override fun getDocumentStorage(): IStoredDocumentStorage {
        return documentStorage
    }
}