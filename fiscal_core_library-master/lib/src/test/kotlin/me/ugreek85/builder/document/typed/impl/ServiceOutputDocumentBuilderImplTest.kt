package me.ugreek85.builder.document.typed.impl

import me.ugreek85.document.common.DocumentType
import me.ugreek85.document.common.IDocument
import me.ugreek85.document.common.InternalDocumentSubType
import me.ugreek85.document.common.InternalDocumentType
import me.ugreek85.builder.document.typed.common.impl.TypedDocumentBuilderFactoryImpl
import me.ugreek85.mocks.RegistrarInfoMock
import me.ugreek85.mocks.RegistrarStateMock
import me.ugreek85.document.receipt.IReceiptDocument
import me.ugreek85.utils.DocumentValidationUtil
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ServiceOutputDocumentBuilderImplTest {

    private val date = DocumentValidationUtil.getCheckDate()
    private val registrarInfo = RegistrarInfoMock.mock()
    private val registrarState = RegistrarStateMock.mock()
    private val cashierName = "Test Cashier Name"
    private val sum = 100.0

    private fun checkDocument(document: IDocument)
    {
        assertEquals(document.getDocumentType(), DocumentType.ServiceOutput)
        assertEquals(document.getDocumentHeader().getInternalDocumentType(), InternalDocumentType.SALE)
        assertEquals(document.getDocumentHeader().getInternalDocumentSubType(), InternalDocumentSubType.SERVICE_ISSUE)

        val receiptDocument = document as IReceiptDocument
        assertEquals(receiptDocument.getTotal()!!.getSum(), sum)
    }

    @Test
    fun buildOnlineDocument() {

        val builder = TypedDocumentBuilderFactoryImpl
            .newInstance()
            .newServiceOutputDocumentBuilder()

        val document = builder
            .setDate(date)
            .setRegistrarInfo(registrarInfo)
            .setRegistrarState(registrarState)
            .setCashierName(cashierName)
            .setSum(sum)
            .build()


        assertEquals(document.getDocumentName(), "ServiceOutput")
        checkDocument(document)

        DocumentValidationUtil.checkDateAndTime(document)
        DocumentValidationUtil.checkReceiptDocument(document)
        DocumentValidationUtil.checkOnlineDocument(document)
    }

    @Test
    fun buildOfflineDocument() {

        val builder = TypedDocumentBuilderFactoryImpl
            .newInstance()
            .newServiceOutputDocumentBuilder()

        val document = builder
            .setDate(date)
            .setRegistrarInfo(registrarInfo)
            .setRegistrarState(registrarState)
            .setCashierName(cashierName)
            .setSum(sum)
            .setOffline(true)
            .setPreviousDocumentHash(DocumentValidationUtil.getCheckPreviousDocumentHash())
            .build()

        assertEquals(document.getDocumentName(), "OfflineServiceOutput")

        checkDocument(document)

        DocumentValidationUtil.checkDateAndTime(document)
        DocumentValidationUtil.checkReceiptDocument(document)

        assertEquals(document.isOfflineDocument(), true)
        assertEquals(document.getDocumentHeader().isOffline(), true)
        assertEquals(document.getDocumentHeader().getPreviousDocumentHash(),
            DocumentValidationUtil.getCheckPreviousDocumentHash()
        )
        assertEquals(document.getDocumentHeader().getFiscalNumber(), "10832.9.6343")
    }
}