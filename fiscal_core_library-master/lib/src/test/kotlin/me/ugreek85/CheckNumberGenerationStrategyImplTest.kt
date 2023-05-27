package me.ugreek85

import me.ugreek85.builder.document.offline_fiscal_number.impl.CheckNumberGenerationStrategyImpl
import me.ugreek85.utils.Crc32
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.nio.charset.Charset

internal class CheckNumberGenerationStrategyImplTest {

    @Test
    fun additionalCheckNumberHandler() {

        val line = "179625192271939,20082020,142338,10,4000002411,10,cdd68bb111f8993f3603f0179341571b35b73a07d5acee9b28fbfb714698e1b3"
        val result = CheckNumberGenerationStrategyImpl().additionalCheckNumberHandler(Crc32.get(line.toByteArray(Charset.forName("windows-1251"))))
        assertEquals(result, 4758)

    }

    @Test
    fun createCheckNumber() {

        val result = CheckNumberGenerationStrategyImpl().createCheckNumber(
            "179625192271939",
            "20082020",
            "142338",
            10,
            4000002411,
            10,
            null,
            "cdd68bb111f8993f3603f0179341571b35b73a07d5acee9b28fbfb714698e1b3"
        )

        val checkValue = 3185294758
        assertEquals(result.toUInt(), checkValue.toUInt())
    }
}