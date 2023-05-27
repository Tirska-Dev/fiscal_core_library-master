package me.ugreek85.storage

import me.ugreek85.extentions.mkdirsIfNotExists
import java.io.File
import java.util.*

object TestData {

    val rootDirectory:File
        get() {
            return File("tmp/data/registrars").apply {
                mkdirsIfNotExists()
            }
        }

    val dateCreation: Date = Date("Aug 22, 2021 4:38:57 PM")

    const val registrarId: Long = 4000104487
    const val registrarId2: Long = 5000104487
    const val registrarIdNotFound: Long = 1234567890


    const val localDocumentNumber: Long = 1
    const val localDocumentNumber2: Long = 2

    const val shiftId: String = "12345"
    const val shiftIdOffline: String = "60729.301.1195"
    const val shiftIdNotFound: String = "1234567890"

    const val fiscalNumber: String = "12345"
    const val fiscalNumber2: String = "23210"

    const val offlineSeed = "236942704136957"
    const val offlineSessionId = "60729"

}