package me.ugreek85.utils

import me.ugreek85.document.common.IDocument
import me.ugreek85.document.receipt.IReceiptDocument
import me.ugreek85.document.report.IReportDocument
import org.junit.jupiter.api.Assertions
import java.util.*

object DocumentValidationUtil {

    fun getCheckDate(): Date
    {
        return Date(1597922618000L)
    }

    fun getCheckPreviousDocumentHash(): String
    {
        return "cdd68bb111f8993f3603f0179341571b35b73a07d5acee9b28fbfb714698e1b3"
    }

    fun checkDateAndTime(document: IDocument)
    {
        Assertions.assertEquals(document.getDocumentHeader().getDate(), "20082020")
        Assertions.assertEquals(document.getDocumentHeader().getTime(), "142338")
    }

    fun checkReceiptDocument(document: IDocument)
    {
        Assertions.assertTrue(document is IReceiptDocument)
    }

    fun checkReportDocument(document: IDocument)
    {
        Assertions.assertTrue(document is IReportDocument)
    }

    fun checkOnlineDocument(document: IDocument)
    {
        Assertions.assertEquals(document.isOfflineDocument(), false)
        Assertions.assertEquals(document.getDocumentHeader().isOffline(), null)
        Assertions.assertEquals(document.getDocumentHeader().getPreviousDocumentHash(), null)
        Assertions.assertEquals(document.getDocumentHeader().isRevokeLastOnlineDocument(), null)
    }

    fun checkOfflineDocument(document: IDocument)
    {
        Assertions.assertEquals(document.isOfflineDocument(), true)
        Assertions.assertEquals(document.getDocumentHeader().isOffline(), true)
        Assertions.assertEquals(document.getDocumentHeader().getPreviousDocumentHash(), getCheckPreviousDocumentHash())
        Assertions.assertEquals(document.getDocumentHeader().getFiscalNumber(), "10832.9.4758")
    }

}