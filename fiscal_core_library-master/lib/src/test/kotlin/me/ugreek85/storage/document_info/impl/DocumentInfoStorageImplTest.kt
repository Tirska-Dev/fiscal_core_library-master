package me.ugreek85.storage.document_info.impl

import me.ugreek85.document.common.DocumentType
import me.ugreek85.storage.TestData
import me.ugreek85.storage.common.DirectoryUtil
import me.ugreek85.storage.common.impl.file.DataStorageImpl
import me.ugreek85.storage.document_info.DocumentInfoState
import me.ugreek85.storage.document_info.IDocumentInfo
import me.ugreek85.storage.document_info.impl.file.DocumentInfoStorageImpl
import me.ugreek85.storage.stored_document.IStoredDocument
import me.ugreek85.storage.stored_document.IStoredDocumentStorage
import me.ugreek85.storage.stored_document.impl.file.OnlineStoredDocumentStorageImpl
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import java.util.*

internal class DocumentInfoStorageImplTest {


    private val storage = DocumentInfoStorageImpl(
        DataStorageImpl(TestData.rootDirectory),
        OnlineStoredDocumentStorageImpl(TestData.rootDirectory)
    )

    @BeforeEach
    fun init()
    {
        TestData.rootDirectory.apply {

            if(this.exists())
            {
                DirectoryUtil.deleteRecursively(this)
            }
            else mkdirs()
        }
    }

    private fun isValidDocumentInfo(documentInfo: IDocumentInfo, state: DocumentInfoState, type: DocumentType)
    {
        assertEquals(TestData.dateCreation, documentInfo.getDate())
        assertEquals(TestData.registrarId, documentInfo.getRegistrarId())
        assertEquals(type, documentInfo.getDocumentType())
        assertEquals(state, documentInfo.getState())
        assertEquals(TestData.localDocumentNumber, documentInfo.getLocalNumber())
        assertEquals(false, documentInfo.isCanceled())
        assertEquals(false, documentInfo.isRevoked())
    }

    private fun isValidFiscalNumberAndShiftId(documentInfo: IDocumentInfo)
    {
        assertEquals(TestData.fiscalNumber, documentInfo.getFiscalNumber())
        assertEquals(TestData.shiftId, documentInfo.getShiftId())
    }

    @Test
    fun add() {

        lateinit var documentInfo: IDocumentInfo
        assertDoesNotThrow{
            documentInfo = storage.new()
        }

        documentInfo.setRegistrarId(TestData.registrarId)
        documentInfo.setDocumentType(DocumentType.OpenShift)
        documentInfo.setState(DocumentInfoState.CREATED)
        documentInfo.setLocalNumber(1)
        documentInfo.setDate(TestData.dateCreation)


        assertDoesNotThrow {
            storage.add(documentInfo)
        }

        assertTrue(File(File(TestData.rootDirectory, documentInfo.getRegistrarId().toString()),"tmp").exists())
    }

    @Test
    fun getTmp() {

        add()

        val documentInfo = storage.getTmp(TestData.registrarId)!!
        assertNotNull(documentInfo)

        isValidDocumentInfo(documentInfo, DocumentInfoState.CREATED, DocumentType.OpenShift)
    }

    @Test
    fun update() {

        add()

        var documentInfo = storage.getTmp(TestData.registrarId)!!
        assertNotNull(documentInfo)

        documentInfo.setFiscalNumber(TestData.fiscalNumber)
        documentInfo.setShiftId(TestData.shiftId)
        documentInfo.setState(DocumentInfoState.ACCEPTED)

        assertDoesNotThrow {
            storage.update(documentInfo)
        }

        assertNull(storage.getTmp(TestData.registrarId))
        documentInfo = storage.getByLocalNumber(TestData.registrarId, TestData.localDocumentNumber)!!

        isValidDocumentInfo(documentInfo, DocumentInfoState.ACCEPTED, DocumentType.OpenShift)
        isValidFiscalNumberAndShiftId(documentInfo)
    }


    @Test
    fun getByFiscalNumber() {

        update()

        val documentInfo = storage.getByFiscalNumber(TestData.registrarId, TestData.fiscalNumber)!!

        isValidDocumentInfo(documentInfo, DocumentInfoState.ACCEPTED, DocumentType.OpenShift)
        isValidFiscalNumberAndShiftId(documentInfo)
    }

    @Test
    fun getByLocalNumber() {

        update()

        val documentInfo = storage.getByLocalNumber(TestData.registrarId, TestData.localDocumentNumber)!!

        isValidDocumentInfo(documentInfo, DocumentInfoState.ACCEPTED, DocumentType.OpenShift)
        isValidFiscalNumberAndShiftId(documentInfo)
    }

    @Test
    fun getAllByShiftId() {

        update()

        lateinit var documents: List<IDocumentInfo>
        assertDoesNotThrow {
            documents = storage.getAllByShiftId(TestData.registrarId, TestData.shiftId)
        }

        assertEquals(1, documents.size)

        isValidDocumentInfo(documents.first(), DocumentInfoState.ACCEPTED, DocumentType.OpenShift)
        isValidFiscalNumberAndShiftId(documents.first())

    }

    @Test
    fun count() {

        update()

        assertEquals(1, storage.count(TestData.registrarId))
    }

    @Test
    fun getLast() {

        update()

        lateinit var documentInfo: IDocumentInfo
        assertDoesNotThrow{
            documentInfo = storage.getLast(TestData.registrarId)!!
        }

        isValidDocumentInfo(documentInfo, DocumentInfoState.ACCEPTED, DocumentType.OpenShift)
        isValidFiscalNumberAndShiftId(documentInfo)
    }

    //    @Test
//    fun isValidShiftId() {
//
//        val storage = DocumentInfoStorageFileImpl(File("."))
//        assertTrue(storage.isValidShiftId("10"))
//        assertTrue(storage.isValidShiftId("10.22.43"))
//        assertFalse(storage.isValidShiftId("1022.43"))
//        assertFalse(storage.isValidShiftId("10x22x43"))
//        assertTrue(storage.isValidShiftId("0.0.0"))
//        assertFalse(storage.isValidShiftId("0.0.0."))
//    }
    @Test
    fun getDocumentStorage() {

        update()

        lateinit var documentInfo: IDocumentInfo
        assertDoesNotThrow{
            documentInfo = storage.getLast(TestData.registrarId)!!
        }

        lateinit var documentStorage: IStoredDocumentStorage
        assertDoesNotThrow {
            documentStorage = storage.getDocumentStorage()
        }


        assertNull(documentStorage.get(documentInfo))

        lateinit var document: IStoredDocument

        assertDoesNotThrow{

            document = documentStorage.save(documentInfo, "Test Stored Document".toByteArray())
        }

        assertEquals("bb8ec1d8fe96a6f9034dd8e038313f6908c1eecfb708360c9cbf4cb07c87d990", document.getHash())
        assertEquals(20, document.getSize())
    }

}