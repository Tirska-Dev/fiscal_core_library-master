package me.ugreek85.document.report

import me.ugreek85.document.common.IDocumentPayForm

interface IReportPayForm : IDocumentPayForm {

    fun setSum(sum: Double)
    fun getSum(): Double
}