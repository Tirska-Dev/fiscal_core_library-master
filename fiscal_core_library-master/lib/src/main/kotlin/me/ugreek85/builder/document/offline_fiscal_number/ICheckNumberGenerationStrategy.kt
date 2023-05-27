package me.ugreek85.builder.document.offline_fiscal_number


interface ICheckNumberGenerationStrategy {

    fun additionalCheckNumberHandler(crc32: Int): Int

    fun createCheckNumber(offlineSeed: String,
                          date: String,
                          time: String,
                          documentNumber: Long,
                          registrarId: Long,
                          registrarLocalNumber: Long,
                          sum: Double?,
                          previousDocumentHash: String?): Int
}