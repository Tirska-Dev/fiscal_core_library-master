package me.ugreek85.view.html.impl

import me.ugreek85.builder.document.base.impl.DocumentFactoriesImpl
import me.ugreek85.utils.ResourcesUtil
import me.ugreek85.view.xml.impl.XmlDeserializer
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class HtmlSerializerTest {

    private val xmlDeserializer = XmlDeserializer()
    private val htmlSerializer = HtmlSerializer()

    @Test
    fun serialize() {


        val reportInputBytes = ResourcesUtil.readBytes("report_2.xml")
        val reportDocument = xmlDeserializer.deserialize(reportInputBytes, DocumentFactoriesImpl())

        val bytes = htmlSerializer.serialize(reportDocument)
        assertTrue(bytes.isNotEmpty())
        val html = String(bytes)
        assertTrue(html.contains("<html lang=\"ua\">"))
    }
}
