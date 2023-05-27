package me.ugreek85.view.xml.impl

import me.ugreek85.builder.document.base.IDocumentFactories
import me.ugreek85.document.common.IDocument
import me.ugreek85.document.receipt.IReceiptDocument
import me.ugreek85.document.report.IReportDocument
import me.ugreek85.utils.CopyObjectUtil
import me.ugreek85.view.IDocumentDeserializer
import me.ugreek85.view.xml.impl.receipt.XmlReceiptDocument
import me.ugreek85.view.xml.impl.report.XmlReportDocument
import me.ugreek85.view.xml.impl.util.XmlMapperUtil
import java.io.ByteArrayInputStream
import java.lang.IllegalArgumentException

class XmlDeserializer : IDocumentDeserializer<ByteArray> {

    override fun deserialize(data: ByteArray, documentFactories: IDocumentFactories): IDocument {

        if(isReceiptDocument(data)) return deserializeReceiptDocument(data, documentFactories)
        else if(isReportDocument(data)) return deserializeReportDocument(data, documentFactories)

        throw IllegalArgumentException("Data is not valid")
    }

    private fun deserializeReportDocument(data: ByteArray, documentFactories: IDocumentFactories): IReportDocument
    {
        val reportDocument: IReportDocument  = ByteArrayInputStream(data).use {
            XmlMapperUtil.fromXML(XmlReportDocument::class.java, it)
        }

        return documentFactories.getReportDocumentFactoriesSet().newReportDocument().apply {
            CopyObjectUtil.copyByInterface(IReportDocument::class.java, reportDocument, this)
        }
    }

    private fun deserializeReceiptDocument(data: ByteArray, documentFactories: IDocumentFactories): IReceiptDocument
    {
        val receiptDocument: IReceiptDocument  = ByteArrayInputStream(data).use {
            XmlMapperUtil.fromXML(XmlReceiptDocument::class.java, it)
        }

        return documentFactories.getReceiptDocumentFactoriesSet().newReceiptDocument().apply {
            CopyObjectUtil.copyByInterface(IReceiptDocument::class.java, receiptDocument, this)
        }
    }

    fun isReportDocument(data: ByteArray): Boolean
    {
        if(isTooSmall(data)) return false
        return isContains(data, "<ZREP")
    }

    fun isReceiptDocument(data: ByteArray): Boolean
    {
        if(isTooSmall(data)) return false
        return isContains(data, "<CHECK")
    }

    fun isContains(data: ByteArray, key: String): Boolean
    {
        return data.decodeToString(0, 100)
            .indexOf(key, 0, true) != -1
    }

    fun isTooSmall(data: ByteArray): Boolean
    {
        return data.size < 100
    }
}