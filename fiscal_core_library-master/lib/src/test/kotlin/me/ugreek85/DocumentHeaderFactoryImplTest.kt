package me.ugreek85

import me.ugreek85.document.common.IDocumentHeader
import me.ugreek85.document.common.impl.DocumentHeaderFactoryImpl
import me.ugreek85.mocks.RegistrarInfoMock
import me.ugreek85.mocks.RegistrarStateMock

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

internal class DocumentHeaderFactoryImplTest {

    private val date = Date(1616950274960L)
    private val registrarInfo = RegistrarInfoMock.mock()
    private val registrarState = RegistrarStateMock.mock()
    private val cashierName = "Test Cashier Name"

    @Test
    fun create() {

        val documentHeaderFactory = DocumentHeaderFactoryImpl()
        val documentHeader: IDocumentHeader = documentHeaderFactory.create(
            date,
            registrarInfo,
            registrarState,
            cashierName
        )

        assertEquals(documentHeader.getVersion(),1)
        assertNotEquals(documentHeader.getUid(),"")
        assertEquals(documentHeader.getDate(),"28032021")
        assertEquals(documentHeader.getTime(),"195114")

        assertEquals(documentHeader.getRegistrarId(), registrarInfo.getRegistrarId())
        assertEquals(documentHeader.getRegistrarLocalNumber(), registrarInfo.getRegistrarLocalNumber())
        assertEquals(documentHeader.getCompanyName(), registrarInfo.getCompanyName())
        assertEquals(documentHeader.getSellerId(), registrarInfo.getSellerId())
        assertEquals(documentHeader.getVatNumber(), registrarInfo.getVatNumber())
        assertEquals(documentHeader.getPointName(), registrarInfo.getPointName())
        assertEquals(documentHeader.getPointAddress(), registrarInfo.getPointAddress())

        assertEquals(documentHeader.isOffline(), null)
        assertEquals(documentHeader.getPreviousDocumentHash(), null)
        assertEquals(documentHeader.isRevokeLastOnlineDocument(), null)
    }
}