package me.ugreek85.builder.document.typed.impl

import me.ugreek85.builder.document.typed.common.impl.TypedDocumentBuilderFactoryImpl
import me.ugreek85.document.common.DocumentType
import me.ugreek85.document.common.IDocument
import me.ugreek85.document.common.InternalDocumentType
import me.ugreek85.mocks.RegistrarInfoMock
import me.ugreek85.mocks.RegistrarStateMock
import me.ugreek85.utils.DocumentValidationUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class OpenShiftDocumentBuilderImplTest {

    private val date = DocumentValidationUtil.getCheckDate()
    private val registrarInfo = RegistrarInfoMock.mock()
    private val registrarState = RegistrarStateMock.mock()
    private val cashierName = "Test Cashier Name"

    private fun checkDocument(document: IDocument)
    {
        assertEquals(document.getDocumentType(), DocumentType.OpenShift)
        assertEquals(document.getDocumentHeader().getInternalDocumentType(), InternalDocumentType.OPEN_SHIFT)
        assertEquals(document.getDocumentHeader().getInternalDocumentSubType(), null)
    }

    @Test
    fun buildOnlineDocument() {

        val builder = TypedDocumentBuilderFactoryImpl
            .newInstance()
            .newOpenShiftDocumentBuilder()

        val document = builder
            .setDate(date)
            .setRegistrarInfo(registrarInfo)
            .setRegistrarState(registrarState)
            .setCashierName(cashierName)
            .build()


        assertEquals(document.getDocumentName(), "OpenShift")
        checkDocument(document)

        DocumentValidationUtil.checkDateAndTime(document)
        DocumentValidationUtil.checkReceiptDocument(document)
        DocumentValidationUtil.checkOnlineDocument(document)
    }

    @Test
    fun buildOfflineDocument() {

        val builder = TypedDocumentBuilderFactoryImpl
            .newInstance()
            .newOpenShiftDocumentBuilder()

        val document = builder
            .setDate(date)
            .setRegistrarInfo(registrarInfo)
            .setRegistrarState(registrarState)
            .setCashierName(cashierName)
            .setOffline(true)
            .setPreviousDocumentHash(DocumentValidationUtil.getCheckPreviousDocumentHash())
            .build()


        assertEquals(document.getDocumentName(), "OfflineOpenShift")
        checkDocument(document)

        DocumentValidationUtil.checkDateAndTime(document)
        DocumentValidationUtil.checkReceiptDocument(document)
        DocumentValidationUtil.checkOfflineDocument(document)
    }
}