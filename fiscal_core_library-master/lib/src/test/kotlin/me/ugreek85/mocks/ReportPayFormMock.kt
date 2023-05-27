package me.ugreek85.mocks

import io.mockk.every
import io.mockk.mockk
import me.ugreek85.document.report.IReportPayForm

object ReportPayFormMock {

    private val reportPayForm: IReportPayForm = mockk()

    fun mock() : IReportPayForm
    {
        every { reportPayForm.getCode() } returns "1"
        every { reportPayForm.getName() } returns "Банк"
        every { reportPayForm.getSum() } returns 98.23

        return reportPayForm
    }
}