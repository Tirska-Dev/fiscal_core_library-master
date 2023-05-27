package me.ugreek85.utils

import me.ugreek85.document.common.DocumentType
import me.ugreek85.document.common.IDocumentHeader
import me.ugreek85.document.common.InternalDocumentSubType
import me.ugreek85.document.common.InternalDocumentType
import me.ugreek85.document.common.impl.DocumentHeaderImpl
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.lang.IllegalArgumentException

internal class DocumentTypeUtilTest {

    @Test
    fun detectDocumentTypeByHeader() {

        testDetectZReport()
        testDetectOpenShift()
        testDetectCloseShift()
        testDetectBeginOffline()
        testDetectFinishOffline()
        testDetectSale()
        testDetectCancel()
        testDetectReturn()
        testDetectServiceInput()
        testDetectServiceOutput()
        testDetectCashWithdrawal()
        testDetectPawn()
        testDetectUnknown()
        testDetectCurrencyExchange();
        testDetectCurrencyInput();
        testDetectCurrencyOutput();
        testDetectCurrencyAdditionalInput();

    }

    @Test
    fun fillDocumentHeaderByDocumentType() {

        testFillZReport()
        testFillOpenShift()
        testFillCloseShift()
        testFillBeginOffline()
        testFillFinishOffline()
        testFillSale()
        testFillReturn()
        testFillCancel()
        testFillServiceInput()
        testFillServiceOutput()
        testFillCashWithdrawal()
        testFillPawn()
        testFillCurrencyExchange();
        testFillCurrencyInput();
        testFillCurrencyOutput();
        testFillCurrencyAdditionalInput();
    }

    private fun testFillZReport()
    {
        val header = createDocumentHeader()
        DocumentTypeUtil.fillDocumentHeaderByDocumentType(header, DocumentType.ZReport)
        assertEquals(null, header.getInternalDocumentType())
        assertEquals(null, header.getInternalDocumentSubType())
    }

    private fun testFillOpenShift()
    {
        val header = createDocumentHeader()
        DocumentTypeUtil.fillDocumentHeaderByDocumentType(header, DocumentType.OpenShift)
        assertEquals(InternalDocumentType.OPEN_SHIFT, header.getInternalDocumentType())
        assertEquals(null, header.getInternalDocumentSubType())
    }

    private fun testFillCloseShift()
    {
        val header = createDocumentHeader()
        DocumentTypeUtil.fillDocumentHeaderByDocumentType(header, DocumentType.CloseShift)
        assertEquals(InternalDocumentType.CLOSE_SHIFT, header.getInternalDocumentType())
        assertEquals(null, header.getInternalDocumentSubType())
    }

    private fun testFillBeginOffline()
    {
        val header = createDocumentHeader()
        DocumentTypeUtil.fillDocumentHeaderByDocumentType(header, DocumentType.BeginOffline)
        assertEquals(InternalDocumentType.BEGIN_OFFLINE_SESSION, header.getInternalDocumentType())
        assertEquals(null, header.getInternalDocumentSubType())
    }

    private fun testFillFinishOffline()
    {
        val header = createDocumentHeader()
        DocumentTypeUtil.fillDocumentHeaderByDocumentType(header, DocumentType.FinishOffline)
        assertEquals(InternalDocumentType.FINISH_OFFLINE_SESSION, header.getInternalDocumentType())
        assertEquals(null, header.getInternalDocumentSubType())
    }

    private fun testFillSale()
    {
        val header = createDocumentHeader()
        DocumentTypeUtil.fillDocumentHeaderByDocumentType(header, DocumentType.Sale)
        assertEquals(InternalDocumentType.SALE, header.getInternalDocumentType())
        assertEquals(InternalDocumentSubType.SALE, header.getInternalDocumentSubType())
    }

    private fun testFillReturn()
    {
        val header = createDocumentHeader()
        DocumentTypeUtil.fillDocumentHeaderByDocumentType(header, DocumentType.Return)
        assertEquals(InternalDocumentType.SALE, header.getInternalDocumentType())
        assertEquals(InternalDocumentSubType.RETURN, header.getInternalDocumentSubType())
    }

    private fun testFillCancel()
    {
        val header = createDocumentHeader()
        DocumentTypeUtil.fillDocumentHeaderByDocumentType(header, DocumentType.Cancel)
        assertEquals(InternalDocumentType.SALE, header.getInternalDocumentType())
        assertEquals(InternalDocumentSubType.CANCEL, header.getInternalDocumentSubType())
    }

    private fun testFillServiceInput()
    {
        val header = createDocumentHeader()
        DocumentTypeUtil.fillDocumentHeaderByDocumentType(header, DocumentType.ServiceInput)
        assertEquals(InternalDocumentType.SALE, header.getInternalDocumentType())
        assertEquals(InternalDocumentSubType.SERVICE_DEPOSIT, header.getInternalDocumentSubType())
    }

    private fun testFillServiceOutput()
    {
        val header = createDocumentHeader()
        DocumentTypeUtil.fillDocumentHeaderByDocumentType(header, DocumentType.ServiceOutput)
        assertEquals(InternalDocumentType.SALE, header.getInternalDocumentType())
        assertEquals(InternalDocumentSubType.SERVICE_ISSUE, header.getInternalDocumentSubType())
    }

    private fun testFillCashWithdrawal()
    {
        val header = createDocumentHeader()
        DocumentTypeUtil.fillDocumentHeaderByDocumentType(header, DocumentType.CashWithdrawal)
        assertEquals(InternalDocumentType.CASH_WITHDRAWAL, header.getInternalDocumentType())
        assertEquals(InternalDocumentSubType.SALE, header.getInternalDocumentSubType())
    }

    private fun testFillPawn()
    {
        val header = createDocumentHeader()
        DocumentTypeUtil.fillDocumentHeaderByDocumentType(header, DocumentType.Pawn)
        assertEquals(InternalDocumentType.PAWN, header.getInternalDocumentType())
        assertEquals(InternalDocumentSubType.SALE, header.getInternalDocumentSubType())
    }


    private fun testFillCurrencyExchange()
    {
        val header = createDocumentHeader()
        DocumentTypeUtil.fillDocumentHeaderByDocumentType(header, DocumentType.CurrencyExchange)
        assertEquals(InternalDocumentType.CURRENCY_EXCHANGE, header.getInternalDocumentType())
        assertEquals(InternalDocumentSubType.SALE, header.getInternalDocumentSubType())
    }

    private fun testFillCurrencyInput()
    {
        val header = createDocumentHeader()
        DocumentTypeUtil.fillDocumentHeaderByDocumentType(header, DocumentType.CurrencyInput)
        assertEquals(InternalDocumentType.CURRENCY_EXCHANGE, header.getInternalDocumentType())
        assertEquals(InternalDocumentSubType.SERVICE_DEPOSIT, header.getInternalDocumentSubType())
    }

    private fun testFillCurrencyOutput()
    {
        val header = createDocumentHeader()
        DocumentTypeUtil.fillDocumentHeaderByDocumentType(header, DocumentType.CurrencyOutput)
        assertEquals(InternalDocumentType.CURRENCY_EXCHANGE, header.getInternalDocumentType())
        assertEquals(InternalDocumentSubType.SERVICE_ISSUE, header.getInternalDocumentSubType())
    }

    private fun testFillCurrencyAdditionalInput()
    {
        val header = createDocumentHeader()
        DocumentTypeUtil.fillDocumentHeaderByDocumentType(header, DocumentType.CurrencyAdditionalInput)
        assertEquals(InternalDocumentType.CURRENCY_EXCHANGE, header.getInternalDocumentType())
        assertEquals(InternalDocumentSubType.ADDITIONAL_DEPOSIT, header.getInternalDocumentSubType())
    }

    private fun testDetectZReport()
    {
        val header = createDocumentHeader()
        assertEquals(DocumentType.ZReport, DocumentTypeUtil.detectDocumentTypeByHeader(header))
    }

    private fun testDetectOpenShift()
    {
        val header = createDocumentHeader(InternalDocumentType.OPEN_SHIFT)
        assertEquals(DocumentType.OpenShift, DocumentTypeUtil.detectDocumentTypeByHeader(header))
    }

    private fun testDetectCloseShift()
    {
        val header = createDocumentHeader(InternalDocumentType.CLOSE_SHIFT)
        assertEquals(DocumentType.CloseShift, DocumentTypeUtil.detectDocumentTypeByHeader(header))
    }

    private fun testDetectBeginOffline()
    {
        val header = createDocumentHeader(InternalDocumentType.BEGIN_OFFLINE_SESSION)
        assertEquals(DocumentType.BeginOffline, DocumentTypeUtil.detectDocumentTypeByHeader(header))
    }

    private fun testDetectFinishOffline()
    {
        val header = createDocumentHeader(InternalDocumentType.FINISH_OFFLINE_SESSION)
        assertEquals(DocumentType.FinishOffline, DocumentTypeUtil.detectDocumentTypeByHeader(header))
    }

    private fun testDetectSale()
    {
        val header = createDocumentHeader(InternalDocumentType.SALE, InternalDocumentSubType.SALE)
        assertEquals(DocumentType.Sale, DocumentTypeUtil.detectDocumentTypeByHeader(header))
    }

    private fun testDetectCancel()
    {
        val header = createDocumentHeader(InternalDocumentType.SALE, InternalDocumentSubType.CANCEL)
        assertEquals(DocumentType.Cancel, DocumentTypeUtil.detectDocumentTypeByHeader(header))
    }

    private fun testDetectReturn()
    {
        val header = createDocumentHeader(InternalDocumentType.SALE, InternalDocumentSubType.RETURN)
        assertEquals(DocumentType.Return, DocumentTypeUtil.detectDocumentTypeByHeader(header))
    }

    private fun testDetectServiceInput()
    {
        val header = createDocumentHeader(InternalDocumentType.SALE, InternalDocumentSubType.SERVICE_DEPOSIT)
        assertEquals(DocumentType.ServiceInput, DocumentTypeUtil.detectDocumentTypeByHeader(header))
    }

    private fun testDetectServiceOutput()
    {
        val header = createDocumentHeader(InternalDocumentType.SALE, InternalDocumentSubType.SERVICE_ISSUE)
        assertEquals(DocumentType.ServiceOutput, DocumentTypeUtil.detectDocumentTypeByHeader(header))
    }

    private fun testDetectCashWithdrawal()
    {
        val header = createDocumentHeader(InternalDocumentType.CASH_WITHDRAWAL, InternalDocumentSubType.SALE)
        assertEquals(DocumentType.CashWithdrawal, DocumentTypeUtil.detectDocumentTypeByHeader(header))
    }

    private fun testDetectPawn()
    {
        val header = createDocumentHeader(InternalDocumentType.PAWN, InternalDocumentSubType.SALE)
        assertEquals(DocumentType.Pawn, DocumentTypeUtil.detectDocumentTypeByHeader(header))
    }

    private fun testDetectCurrencyExchange()
    {
        val header = createDocumentHeader(InternalDocumentType.CURRENCY_EXCHANGE, InternalDocumentSubType.SALE)
        assertEquals(DocumentType.CurrencyExchange, DocumentTypeUtil.detectDocumentTypeByHeader(header))
    }

    private fun testDetectCurrencyOutput()
    {
        val header = createDocumentHeader(InternalDocumentType.CURRENCY_EXCHANGE, InternalDocumentSubType.SERVICE_ISSUE)
        assertEquals(DocumentType.CurrencyOutput, DocumentTypeUtil.detectDocumentTypeByHeader(header))
    }

    private fun testDetectCurrencyInput()
    {
        val header = createDocumentHeader(InternalDocumentType.CURRENCY_EXCHANGE, InternalDocumentSubType.SERVICE_DEPOSIT)
        assertEquals(DocumentType.CurrencyInput, DocumentTypeUtil.detectDocumentTypeByHeader(header))
    }

    private fun testDetectCurrencyAdditionalInput()
    {
        val header = createDocumentHeader(InternalDocumentType.CURRENCY_EXCHANGE, InternalDocumentSubType.ADDITIONAL_DEPOSIT)
        assertEquals(DocumentType.CurrencyAdditionalInput, DocumentTypeUtil.detectDocumentTypeByHeader(header))
    }

    private fun testDetectUnknown()
    {
        val header = createDocumentHeader(InternalDocumentType.SALE)
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            DocumentTypeUtil.detectDocumentTypeByHeader(header)
        }
    }

    private fun createDocumentHeader(type: InternalDocumentType? = null, subType: InternalDocumentSubType? = null) : IDocumentHeader
    {
        return DocumentHeaderImpl().apply {
            setInternalDocumentType(type)
            setInternalDocumentSubType(subType)
        }
    }
}
