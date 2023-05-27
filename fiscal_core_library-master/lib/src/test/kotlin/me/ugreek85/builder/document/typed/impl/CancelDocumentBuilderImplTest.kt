package me.ugreek85.builder.document.typed.impl

import me.ugreek85.document.common.DocumentType
import me.ugreek85.document.common.IDocument
import me.ugreek85.document.common.InternalDocumentSubType
import me.ugreek85.document.common.InternalDocumentType
import me.ugreek85.builder.document.typed.common.impl.TypedDocumentBuilderFactoryImpl
import me.ugreek85.mocks.RegistrarInfoMock
import me.ugreek85.mocks.RegistrarStateMock
import me.ugreek85.utils.DocumentValidationUtil
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CancelDocumentBuilderImplTest {

    private val date = DocumentValidationUtil.getCheckDate()
    private val registrarInfo = RegistrarInfoMock.mock()
    private val registrarState = RegistrarStateMock.mock()
    private val cashierName = "Test Cashier Name"
    private val fiscalNumberForDelete = "232123"


    private fun checkDocument(document: IDocument)
    {
        assertEquals(document.getDocumentType(), DocumentType.Cancel)
        assertEquals(document.getDocumentHeader().getInternalDocumentType(), InternalDocumentType.SALE)
        assertEquals(document.getDocumentHeader().getInternalDocumentSubType(), InternalDocumentSubType.CANCEL)
    }

    @Test
    fun buildOnlineDocument() {

        val builder = TypedDocumentBuilderFactoryImpl
            .newInstance()
            .newCancelDocumentBuilder()

        val document = builder
            .setDate(date)
            .setRegistrarInfo(registrarInfo)
            .setRegistrarState(registrarState)
            .setCashierName(cashierName)
            .setFiscalNumberForDelete(fiscalNumberForDelete)
            .build()


        assertEquals(document.getDocumentName(), "Cancel")
        assertEquals(document.getDocumentHeader().getFiscalNumberForCancel(), fiscalNumberForDelete)
        checkDocument(document)

        DocumentValidationUtil.checkDateAndTime(document)
        DocumentValidationUtil.checkReceiptDocument(document)
        DocumentValidationUtil.checkOnlineDocument(document)
    }

    @Test
    fun buildOfflineDocument() {

        val builder = TypedDocumentBuilderFactoryImpl
            .newInstance()
            .newCancelDocumentBuilder()

        val document = builder
            .setDate(date)
            .setRegistrarInfo(registrarInfo)
            .setRegistrarState(registrarState)
            .setCashierName(cashierName)
            .setFiscalNumberForDelete(fiscalNumberForDelete)
            .setOffline(true)
            .setPreviousDocumentHash(DocumentValidationUtil.getCheckPreviousDocumentHash())
            .build()


        assertEquals(document.getDocumentName(), "OfflineCancel")
        assertEquals(document.getDocumentHeader().getFiscalNumberForCancel(), fiscalNumberForDelete)
        checkDocument(document)

        DocumentValidationUtil.checkDateAndTime(document)
        DocumentValidationUtil.checkReceiptDocument(document)
        DocumentValidationUtil.checkOfflineDocument(document)
    }
}