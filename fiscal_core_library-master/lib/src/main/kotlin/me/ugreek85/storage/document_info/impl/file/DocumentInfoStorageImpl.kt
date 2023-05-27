package me.ugreek85.storage.document_info.impl.file

import me.ugreek85.storage.common.IDataStorage
import me.ugreek85.storage.common.SerializeUtil
import me.ugreek85.storage.document_info.DocumentInfoState
import me.ugreek85.storage.document_info.IDocumentInfo
import me.ugreek85.storage.document_info.IDocumentInfoStorage
import me.ugreek85.storage.stored_document.IStoredDocumentStorage
import java.io.File


class DocumentInfoStorageImpl(

//    workingDirectory: File,
    private val dataStorage: IDataStorage,
    private val documentStorage: IStoredDocumentStorage

) : IDocumentInfoStorage/*, PathAndShiftAbility(workingDirectory), IDocumentAbility*/ {

    private fun getPath(documentInfo: IDocumentInfo): File
    {
        return getPath(
            documentInfo.getRegistrarId(),
            documentInfo.getLocalNumber(),
            documentInfo.getShiftId(),
            documentInfo.getState(),
            true)
    }


    private fun getTmpPath(registrarId: Long): File
    {
        return getPath(registrarId, 0, null, DocumentInfoState.CREATED)
    }

    private fun getPath(registrarId: Long, localNumber: Long, shiftId: String? = null): File
    {
        return getPath(registrarId, localNumber, shiftId, DocumentInfoState.ACCEPTED)
    }

    private fun getPath(registrarId: Long, localNumber: Long, shiftId: String?, documentInfoState: DocumentInfoState, createIfNotExists: Boolean = false): File
    {
        return if(documentInfoState == DocumentInfoState.CREATED ||
            documentInfoState == DocumentInfoState.SENDING) {
            File(
                dataStorage.getRootPathForRegistrar(registrarId, createIfNotExists),
                "tmp"
            )
        } else File(
            dataStorage.getRootPathForShift(registrarId, shiftId!!, createIfNotExists),
            localNumber.toString()
        )
    }

    private fun getFiscalNumberIndexPath(registrarId: Long, fiscalNumber: String): File {
        return File(
            dataStorage.getRootPathForFiscalNumberIndex(registrarId, true),
            fiscalNumber)
    }

    private fun getLocalNumberIndexPath(registrarId: Long, localNumber: Long): File {
        return File(
            dataStorage.getRootPathForLocalNumberIndex(registrarId, true),
            localNumber.toString())
    }

    private fun createFiscalNumberIndex(registrarId: Long, fiscalNumber: String, localNumber: Long)
    {
        val indexFile = getFiscalNumberIndexPath(registrarId, fiscalNumber)
        SerializeUtil.save(indexFile, FiscalNumberIndex(localNumber))
    }

    private fun createLocalNumberIndex(registrarId: Long, localNumber: Long, shiftId: String)
    {
        val indexFile = getLocalNumberIndexPath(registrarId, localNumber)
        SerializeUtil.save(indexFile, LocalNumberIndex(shiftId))
    }

    private fun getDocuments(registrarId: Long, shiftId: String, externalArrayOfShifts: Array<File>? = null): Array<File>
    {
        val shifts = externalArrayOfShifts ?: dataStorage.getUnorderedShiftPathList(registrarId)
        val shiftDirectory = dataStorage.searchShift(shifts, shiftId) ?: return emptyArray()
        return dataStorage.getDocumentPathList(shiftDirectory)
    }


    private fun createIndexes(documentInfo: IDocumentInfo)
    {
        createLocalNumberIndex(documentInfo.getRegistrarId(),
            documentInfo.getLocalNumber(),
            documentInfo.getShiftId()!!
        )

        createFiscalNumberIndex(documentInfo.getRegistrarId(),
            documentInfo.getFiscalNumber()!!,
            documentInfo.getLocalNumber()
        )
    }

    private fun deleteTmpFile(documentInfo: IDocumentInfo)
    {
        getPath(documentInfo.getRegistrarId(), documentInfo.getLocalNumber(), null, DocumentInfoState.CREATED)
            .delete()
    }

    override fun new(): IDocumentInfo {
        return DocumentInfoImpl()
    }

    override fun add(documentInfo: IDocumentInfo) {
        SerializeUtil.save(getPath(documentInfo), documentInfo)
    }

    override fun update(documentInfo: IDocumentInfo) {

        SerializeUtil.save(getPath(documentInfo), documentInfo)
        if(documentInfo.getState() == DocumentInfoState.ACCEPTED) {
            createIndexes(documentInfo)
            deleteTmpFile(documentInfo)
        }
    }

    override fun getByFiscalNumber(registrarId: Long, fiscalNumber: String): IDocumentInfo? {

        val indexFile = getFiscalNumberIndexPath(registrarId, fiscalNumber)
        if(indexFile.exists()) {
            val indexObject = SerializeUtil.load<FiscalNumberIndex>(indexFile)
            return getByLocalNumber(registrarId, indexObject.localNumber)
        }
        return null
    }

    override fun getByLocalNumber(registrarId: Long, localNumber: Long): IDocumentInfo? {
        val indexFile = getLocalNumberIndexPath(registrarId, localNumber)
        if(!indexFile.exists()) return null

        val indexObject = SerializeUtil.load<LocalNumberIndex>(indexFile)
        val documentInfoPath = getPath(registrarId, localNumber, indexObject.shiftId)
        if(!documentInfoPath.exists()) return null

        return SerializeUtil.load<DocumentInfoImpl>(documentInfoPath)
    }

    override fun getAllByShiftId(registrarId: Long, shiftId: String): List<IDocumentInfo> {
        val files = getDocuments(registrarId, shiftId)
        return files.map { SerializeUtil.load<DocumentInfoImpl>(it) }
    }

    override fun count(registrarId: Long): Long {

        val shifts = dataStorage.getUnorderedShiftPathList(registrarId)
        if(shifts.isEmpty()) return 0

        var counter = 0L

        shifts.forEachIndexed { _, shiftDirectory ->
            counter += dataStorage.getDocumentPathList(shiftDirectory).size
        }

        return counter
    }

    override fun getLast(registrarId: Long): IDocumentInfo? {

        val shifts = dataStorage.getUnorderedShiftPathList(registrarId)
        if(shifts.isEmpty()) return null

        val files = getDocuments(registrarId, shifts.last().name, shifts)
        if(files.isEmpty()) return null

        return SerializeUtil.load<DocumentInfoImpl>(files.last())
    }

    override fun getTmp(registrarId: Long): IDocumentInfo? {
        val path = getTmpPath(registrarId)
        if(!path.exists()) return null
        return SerializeUtil.load<DocumentInfoImpl>(path)
    }


    override fun getDocumentStorage(): IStoredDocumentStorage {
        return documentStorage
    }

}