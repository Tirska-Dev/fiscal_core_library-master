package me.ugreek85.utils

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.xml.sax.SAXParseException

internal class XmlSchemaValidationUtilTest {

    @Test
    fun validateReceiptDocument() {

        val bytes = ResourcesUtil.readBytes("report.xml")

        assertDoesNotThrow {
            XmlSchemaValidationUtil.validateReportDocument(bytes)
        }

        org.junit.jupiter.api.assertThrows<SAXParseException> {
            XmlSchemaValidationUtil.validateReceiptDocument(bytes)
        }

        try
        {
            XmlSchemaValidationUtil.validateReceiptDocument(bytes)
        }
        catch (e:SAXParseException)
        {
            println(e.message)
        }
    }

    @Test
    fun validateReportDocument() {

        val bytes = ResourcesUtil.readBytes("receipt.xml")

        assertDoesNotThrow {
            XmlSchemaValidationUtil.validateReceiptDocument(bytes)
        }

        org.junit.jupiter.api.assertThrows<SAXParseException> {
            XmlSchemaValidationUtil.validateReportDocument(bytes)
        }

        try
        {
            XmlSchemaValidationUtil.validateReportDocument(bytes)
        }
        catch (e:SAXParseException)
        {
            println(e.message)
        }
    }
}
