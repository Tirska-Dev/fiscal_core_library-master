package me.ugreek85.view.json.impl.report

import com.google.gson.annotations.SerializedName
import me.ugreek85.document.report.IReportPayForm
import me.ugreek85.document.common.impl.DocumentPayFormImpl
import me.ugreek85.view.json.impl.document.JsonDocumentPayForm
import kotlin.properties.Delegates

open class JsonReportDocumentPayForm : IReportPayForm, JsonDocumentPayForm() {

    @SerializedName("sum")
    private var mSum: Double = 0.0

    override fun setSum(sum: Double) {
        mSum = sum
    }

    override fun getSum(): Double {
        return mSum
    }
}