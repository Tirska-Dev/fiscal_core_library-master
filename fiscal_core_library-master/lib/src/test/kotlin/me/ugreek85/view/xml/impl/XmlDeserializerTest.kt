package me.ugreek85.view.xml.impl

import me.ugreek85.builder.document.base.impl.DocumentFactoriesImpl
import me.ugreek85.utils.ResourcesUtil
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.security.MessageDigest

internal class XmlDeserializerTest {

    private val xmlDeserializer = XmlDeserializer()
    private val emptyArray = ByteArray(100)
    private val smallSize = ByteArray(99)

    @Test
    fun isReportDocument() {

        val bytes = ResourcesUtil.readBytes("report.xml")
        assertEquals(true, xmlDeserializer.isReportDocument(bytes))
        assertEquals(false, xmlDeserializer.isReportDocument(emptyArray))
        assertEquals(false, xmlDeserializer.isReportDocument(smallSize))
    }

    @Test
    fun isReceiptDocument() {

        val bytes = ResourcesUtil.readBytes("receipt.xml")
        assertEquals(true, xmlDeserializer.isReceiptDocument(bytes))
        assertEquals(false, xmlDeserializer.isReceiptDocument(emptyArray))
        assertEquals(false, xmlDeserializer.isReceiptDocument(smallSize))

        val inputService = ResourcesUtil.readBytes("inputService.xml")
        assertEquals(true, xmlDeserializer.isReceiptDocument(inputService))
    }

    @Test
    fun isTooSmall() {

        assertEquals(false, xmlDeserializer.isTooSmall(emptyArray))
        assertEquals(true, xmlDeserializer.isTooSmall(smallSize))
    }



    @Test
    fun deserialize() {

        testDeserializeReportDocument()
        testDeserializeReceiptDocument()
        testDeserializeBadDocument()
        testDeserializeInputService()
    }

    private fun testDeserializeReportDocument()
    {
        val reportInputBytes = ResourcesUtil.readBytes("report.xml")
        val reportDocument = xmlDeserializer.deserialize(reportInputBytes, DocumentFactoriesImpl())

        val reportOutputBytes = XmlSerializer().serialize(reportDocument)

        assertEquals(reportOutputBytes.size, reportInputBytes.size)
        assertEquals(sha1(reportOutputBytes), sha1(reportInputBytes))
    }

    private fun testDeserializeReceiptDocument()
    {
        val receiptInputBytes = ResourcesUtil.readBytes("receipt.xml")
        val receiptDocument = xmlDeserializer.deserialize(receiptInputBytes, DocumentFactoriesImpl())

        val reportOutputBytes = XmlSerializer().serialize(receiptDocument)

//        assertEquals(reportOutputBytes.size, receiptInputBytes.size)
//        assertEquals(sha1(reportOutputBytes), sha1(receiptInputBytes))
    }

    private fun testDeserializeInputService()
    {
        val receiptInputBytes = ResourcesUtil.readBytes("inputService.xml")
        val receiptDocument = xmlDeserializer.deserialize(receiptInputBytes, DocumentFactoriesImpl())

        assertDoesNotThrow {
            val reportOutputBytes = XmlSerializer().serialize(receiptDocument)
        }


//        assertEquals(reportOutputBytes.size, receiptInputBytes.size)
//        assertEquals(sha1(reportOutputBytes), sha1(receiptInputBytes))
    }

    private fun testDeserializeBadDocument()
    {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            xmlDeserializer.deserialize(emptyArray, DocumentFactoriesImpl())
        }
    }

    private fun sha1(byteArray: ByteArray): String
    {
        val bytes = MessageDigest.getInstance("SHA-1").digest(byteArray)
        return bytes.joinToString("") {
            "%02x".format(it)
        }
    }
}
