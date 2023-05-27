package me.ugreek85.view.json.impl

import me.ugreek85.document.common.IDocument
import me.ugreek85.document.receipt.IReceiptDocument
import me.ugreek85.document.report.IReportDocument
import me.ugreek85.utils.CopyObjectUtil
import me.ugreek85.view.xml.impl.util.XmlMapperUtil
import me.ugreek85.view.IDocumentSerializer
import me.ugreek85.view.json.impl.receipt.JsonReceiptDocument
import me.ugreek85.view.json.impl.util.JsonMapperUtil
import me.ugreek85.view.xml.impl.receipt.XmlReceiptDocument
import me.ugreek85.view.xml.impl.report.XmlReportDocument
import java.io.ByteArrayOutputStream
import java.lang.IllegalStateException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class JsonSerializer : IDocumentSerializer<ByteArray> {

    override fun serialize(document: IDocument, args: Map<String, Any>?): ByteArray {

        if(document is IReportDocument) return serializeReportDocument(document)
        else if(document is IReceiptDocument) return serializeReceiptDocument(document)

        throw IllegalStateException("Document is unknown")
    }

    private fun serializeReportDocument(reportDocument: IReportDocument): ByteArray
    {
//        val xmlReportDocument = XmlReportDocument()
//        CopyObjectUtil.copyByInterface(IReportDocument::class.java, reportDocument, xmlReportDocument)
//
//
//        ByteArrayOutputStream().use {
//            XmlMapperUtil.toXML(xmlReportDocument, it)
//            return it.toByteArray()
//        }
        TODO("Not implemented")
    }

    private fun serializeReceiptDocument(receiptDocument: IReceiptDocument): ByteArray
    {
        val jsonReceiptDocument = JsonReceiptDocument()
        jsonReceiptDocument.setDocumentHeader(receiptDocument.getDocumentHeader())
        CopyObjectUtil.copyByInterface(IReceiptDocument::class.java, receiptDocument, jsonReceiptDocument)
        return JsonMapperUtil.toJSON(jsonReceiptDocument).toByteArray(Charsets.UTF_8)
    }
}
