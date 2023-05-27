package me.ugreek85.view.xml.impl

import me.ugreek85.document.common.InternalDocumentType
import me.ugreek85.view.xml.impl.util.XmlMapperUtil
import me.ugreek85.view.xml.impl.document.XmlDocumentHeader
import me.ugreek85.view.xml.impl.document.XmlDocumentTaxRate
import me.ugreek85.view.xml.impl.receipt.XmlReceiptDocument
import me.ugreek85.view.xml.impl.receipt.XmlReceiptPayForm
import me.ugreek85.view.xml.impl.receipt.XmlReceiptProduct
import me.ugreek85.view.xml.impl.receipt.XmlReceiptTotal
import me.ugreek85.view.xml.impl.report.XmlReportCashTotal
import me.ugreek85.view.xml.impl.report.XmlReportDocument
import me.ugreek85.view.xml.impl.report.XmlReportPayForm
import me.ugreek85.view.xml.impl.report.XmlReportTotal
import org.junit.jupiter.api.Test
import java.io.File
import java.util.*

internal class XmlReceiptDocumentTest {

    @Test
    fun main() {

        val header = XmlDocumentHeader()
        header.setInternalDocumentType(InternalDocumentType.OPEN_SHIFT)
        header.setUid(UUID.randomUUID().toString())
        header.setSellerId("34554363")
        header.setVatNumber("123456789020")
        header.setCompanyName("Тестовий платник 4")
        header.setPointName("Магазин Іван-Тест")
        header.setPointAddress("УКРАЇНА, СУМСЬКА ОБЛ., М. СУМИ, вул. Соборна 1")
        header.setDate("26062021")
        header.setTime("155248")
        header.setDocumentNumber(1987)
        header.setRegistrarLocalNumber(24)
        header.setRegistrarId(4000066879)
        header.setCashierName("Для РРО № 4000066879")
        header.setVersion(1)

        // Receipt
        val receiptDocument = XmlReceiptDocument()
        receiptDocument.setDocumentHeader(header)

        val total = XmlReceiptTotal()
        total.setSum(10.2323)
        total.setDiscountSum(12.0)
        receiptDocument.setTotal(total)


        val receiptPayForms = arrayListOf(
            XmlReceiptPayForm().apply {
                setRow(1)
                setName("ГРОШI")
                setCode("1")
                setSum(999.0)
                setProvidedSum(1000.0)
                setSumOfRemain(1.0)
            },
            XmlReceiptPayForm().apply {
                setRow(2)
                setName("КРЕДИТ")
                setCode("3")
                setSum(3357.390001)
            }
        )
        receiptDocument.setPayForms(receiptPayForms)

        val receiptProducts = arrayListOf(
            XmlReceiptProduct().apply {
                setRow(1)
                setName("Грінберген Бланш 500мл")
                setCode("00919")
                setBarCode("00919")
                setNationalCode("2203001000")
                setUnitCode("ead0a")
                setUnitName("порц")
                setAmount(1.0)
                setPrice(80.0)
                setTaxRateLetter("М")
                setCost(80.0)
                setDiscountSum(0.0)
            },
            XmlReceiptProduct().apply {
                setRow(2)
                setName("Хата \"Диво робить\" 500мл")
                setCode("01025")
                setBarCode("01025")
                setNationalCode("2203001000")
                setUnitCode("47c01")
                setUnitName("порц")
                setAmount(1.0)
                setPrice(70.0)
                setTaxRateLetter("М")
                setCost(70.0)
                setDiscountSum(0.0)
            }
        )

        println(receiptProducts)

        receiptDocument.setProducts(receiptProducts)


        val receiptXml = File("receipt.xml")
        XmlMapperUtil.toXML(receiptDocument, receiptXml)

        val receiptDocument2 = XmlMapperUtil.fromXML(XmlReceiptDocument::class.java, receiptXml)
        println(receiptDocument2)

        // Report
        header.setInternalDocumentType(null)
        val reportDocument = XmlReportDocument()
        reportDocument.setDocumentHeader(header)

        val xmlReportTotal = XmlReportTotal()
        xmlReportTotal.setNumberOfReceipts(1)
        xmlReportTotal.setSum(9.999)

        val payForms = arrayListOf(
            XmlReportPayForm().apply {
                setRow(1)
                setName("ГРОШI")
                setCode("1")
                setSum(10000.001231)
            },
            XmlReportPayForm().apply {
                setRow(2)
                setName("КРЕДИТ")
                setCode("3")
                setSum(3357.390001)
            }
        )
        xmlReportTotal.setPayForms(payForms)

        val taxRates = arrayListOf(
            XmlDocumentTaxRate().apply {
                setRow(1)
                setType(0)
                setName("ПДВ")
                setLetter("A")
                setPercent(20.0)
                setSign(false)
                setTurnoverSum(13977.01)
                setSourceSum(13357.39)
                setSum(2226.23)
            }
        )
        xmlReportTotal.setTaxRates(taxRates)

        reportDocument.setTotalsBySale(xmlReportTotal)
        reportDocument.setTotalsByCash(
            XmlReportCashTotal().apply {
                setSum(10.0)
                setNumberOfReceipts(2)
                setSumOfCommission(1.0)
            }
        )

        val reportXml = File("report.xml")
        XmlMapperUtil.toXML(reportDocument, reportXml)

        val reportDocument2 = XmlMapperUtil.fromXML(XmlReportDocument::class.java, reportXml)
        println(reportDocument2)
    }

    @Test
    fun test()
    {
        val receiptXml = File("receipt.xml")
        val receiptDocument2 = XmlMapperUtil.fromXML(XmlReceiptDocument::class.java, receiptXml)
        println(receiptDocument2)
    }
}