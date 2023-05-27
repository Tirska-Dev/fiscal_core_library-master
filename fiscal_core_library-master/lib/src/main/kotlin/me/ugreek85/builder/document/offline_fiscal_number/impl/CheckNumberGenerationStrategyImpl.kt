package me.ugreek85.builder.document.offline_fiscal_number.impl

import me.ugreek85.builder.document.offline_fiscal_number.ICheckNumberGenerationStrategy
import me.ugreek85.utils.Crc32
import me.ugreek85.utils.roundString
import java.nio.charset.Charset

class CheckNumberGenerationStrategyImpl : ICheckNumberGenerationStrategy {

    override fun additionalCheckNumberHandler(value: Int): Int {
        var crc32 = value
        if (value == 0) crc32 = 1
        var checkNumber = Integer.toUnsignedString(crc32)
        if (checkNumber.length >= 4) {
            checkNumber = checkNumber.substring(checkNumber.length - 4)
        }

        return checkNumber.toInt()
    }

    override fun createCheckNumber(
        offlineSeed: String,
        date: String,
        time: String,
        documentNumber: Long,
        registrarId: Long,
        registrarLocalNumber: Long,
        sum: Double?,
        previousDocumentHash: String?
    ): Int {
        var line = java.lang.String.join(",",
            offlineSeed,
            date,
            time,
            documentNumber.toString(),
            registrarId.toString(),
            registrarLocalNumber.toString())

        sum?.let {
            line = java.lang.String.join(",", line, it.roundString(2))
        }

        previousDocumentHash?.let {
            line = java.lang.String.join(",", line, it)
        }


        return Crc32.get(line.toByteArray(Charset.forName("windows-1251")))
    }
}