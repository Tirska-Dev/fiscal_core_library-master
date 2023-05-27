package me.ugreek85.mocks

import io.mockk.every
import io.mockk.mockk
import me.ugreek85.document.common.IDocumentTaxRate

object DocumentTaxRateMock {

    private val documentTaxRate: IDocumentTaxRate = mockk()

    fun mock() : IDocumentTaxRate
    {
        every { documentTaxRate.getType() } returns 1
        every { documentTaxRate.getName() } returns "Test Name"
        every { documentTaxRate.getLetter() } returns "A"
        every { documentTaxRate.getPercent() } returns 20.0
        every { documentTaxRate.getSign() } returns false
        every { documentTaxRate.getTurnoverSum() } returns 10.2
        every { documentTaxRate.getSourceSum() } returns 21.23
        every { documentTaxRate.getSum() } returns 32.89

        return documentTaxRate
    }
}