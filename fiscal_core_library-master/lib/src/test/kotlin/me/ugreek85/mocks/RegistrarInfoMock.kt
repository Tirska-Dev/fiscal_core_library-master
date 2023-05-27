package me.ugreek85.mocks

import io.mockk.every
import io.mockk.mockk
import me.ugreek85.storage.registrar_info.IRegistrarInfo

object RegistrarInfoMock {

    private val registrarInfo: IRegistrarInfo = mockk()

    fun mock() : IRegistrarInfo
    {
        every { registrarInfo.getRegistrarId() } returns 4000002411
        every { registrarInfo.getRegistrarLocalNumber() } returns 10
        every { registrarInfo.getCompanyName() } returns "Test Company Name"
        every { registrarInfo.getSellerId() } returns "Test Seller ID"
        every { registrarInfo.getVatNumber() } returns "Test Vat Number"
        every { registrarInfo.getPointName() } returns "Test Point Name"
        every { registrarInfo.getPointAddress() } returns "Test Point Address"

        return registrarInfo
    }
}