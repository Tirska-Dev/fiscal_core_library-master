package me.ugreek85.view.json.impl

import me.ugreek85.builder.document.base.impl.DocumentFactoriesImpl
import me.ugreek85.utils.ResourcesUtil
import me.ugreek85.view.xml.impl.XmlDeserializer
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class JsonSerializerTest {

    private val xmlDeserializer = XmlDeserializer()
    private val jsonSerializer = JsonSerializer()

    @Test
    fun serialize() {


        val receiptInputBytes = ResourcesUtil.readBytes("sale_2.xml")
        val receiptDocument = xmlDeserializer.deserialize(receiptInputBytes, DocumentFactoriesImpl())
        val jsonBytes = jsonSerializer.serialize(receiptDocument)

        println(String(jsonBytes, Charsets.UTF_8))



//        println(receiptDocument)

    }
}