package me.ugreek85.view.html.impl


import freemarker.cache.FileTemplateLoader
import freemarker.cache.URLTemplateLoader
import freemarker.template.Configuration
import freemarker.template.Template
import me.ugreek85.document.common.IDocument
import me.ugreek85.document.receipt.IReceiptDocument
import me.ugreek85.document.report.IReportDocument
import me.ugreek85.utils.XmlSchemaValidationUtil
import me.ugreek85.view.IDocumentSerializer
import java.io.*
import java.net.URL
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class HtmlSerializer : IDocumentSerializer<ByteArray> {

    private fun getTemplateConfiguration(): Configuration {
        // Конфигурация
        val cfg = Configuration(Configuration.VERSION_2_3_31)
        cfg.setClassForTemplateLoading(HtmlSerializer::class.java, "/templates")
        cfg.defaultEncoding = Charsets.UTF_8.name()
        return cfg
    }

    override fun serialize(document: IDocument, args: Map<String, Any>?): ByteArray {
        if(document is IReportDocument) return serializeReportDocument(document, args ?: emptyMap())
        else if(document is IReceiptDocument) return serializeReceiptDocument(document)

        throw IllegalStateException("Document is unknown")
    }

    private fun serializeReportDocument(reportDocument: IReportDocument, args: Map<String, Any>): ByteArray
    {
        val cfg = getTemplateConfiguration()


        val root: MutableMap<String, Any> = HashMap()
        root["document"] = reportDocument
        root["documentName"] = args.getOrDefault("documentName", "Z-ЗВІТ")  as String

        val documentDateTime = LocalDateTime.parse("${reportDocument.getDocumentHeader().getDate()}${reportDocument.getDocumentHeader().getTime()}", DateTimeFormatter.ofPattern("ddMMyyyyHHmmss"))
        root["documentDateTime"] = documentDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy"))

        args["shiftId"]?.let {
            root["shiftId"] = it as String
        }

        // шаблон
        val temp: Template = cfg.getTemplate("z-report.ftl")
        return processTemplate(temp, root)
    }

    private fun serializeReceiptDocument(receiptDocument: IReceiptDocument): ByteArray
    {
        TODO()
    }

    private fun processTemplate(temp: Template, data: Map<String, Any>): ByteArray
    {
        ByteArrayOutputStream().use {
            val out: Writer = OutputStreamWriter(it, Charsets.UTF_8)
            temp.process(data, out)
            return it.toByteArray()
        }
    }
}
