package me.ugreek85.builder.document.typed.impl

import me.ugreek85.document.common.DocumentType
import me.ugreek85.document.common.IDocument
import me.ugreek85.document.common.InternalDocumentType
import me.ugreek85.builder.document.typed.common.impl.TypedDocumentBuilderFactoryImpl
import me.ugreek85.mocks.RegistrarInfoMock
import me.ugreek85.mocks.RegistrarStateMock
import me.ugreek85.utils.DocumentValidationUtil
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BeginOfflineDocumentBuilderImplTest {

    private val date = DocumentValidationUtil.getCheckDate()
    private val registrarInfo = RegistrarInfoMock.mock()
    private val registrarState = RegistrarStateMock.mock()
    private val cashierName = "Test Cashier Name"


    private fun checkDocument(document: IDocument) {
        assertEquals(document.getDocumentType(), DocumentType.BeginOffline)
        assertEquals(document.getDocumentHeader().getInternalDocumentType(), InternalDocumentType.BEGIN_OFFLINE_SESSION)
        assertEquals(document.getDocumentHeader().getInternalDocumentSubType(), null)
    }

    @Test
    fun build() {

        val builder = TypedDocumentBuilderFactoryImpl
            .newInstance()
            .newBeginOfflineDocumentBuilder()

        val document = builder
            .setDate(date)
            .setRegistrarInfo(registrarInfo)
            .setRegistrarState(registrarState)
            .setCashierName(cashierName)
            .setRevokeLastOnlineDocument(true)
            .build()


        assertEquals(document.getDocumentName(), "BeginOffline")
        checkDocument(document)

        DocumentValidationUtil.checkDateAndTime(document)
        DocumentValidationUtil.checkReceiptDocument(document)

        println("document.getDocumentHeader().isOffline(): ${document.getDocumentHeader().isOffline()}" )
        println("document.isOfflineDocument(): ${document.isOfflineDocument()}" )

        assertEquals(document.isOfflineDocument(), true)
        assertEquals(document.getDocumentHeader().isOffline(), true)
        assertEquals(document.getDocumentHeader().getPreviousDocumentHash(), null)
        assertEquals(document.getDocumentHeader().isRevokeLastOnlineDocument(), true)
        assertEquals(document.getDocumentHeader().getFiscalNumber(), "10832.9.8531")
    }
}