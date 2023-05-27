package me.ugreek85.document.report.impl

import me.ugreek85.document.report.IReportPayForm
import me.ugreek85.document.common.impl.DocumentPayFormImpl
import kotlin.properties.Delegates

open class ReportDocumentPayFormImpl : IReportPayForm, DocumentPayFormImpl() {

    private var mSum by Delegates.notNull<Double>()

    override fun setSum(sum: Double) {
        mSum = sum
    }

    override fun getSum(): Double {
        return mSum
    }
}