package me.ugreek85.view.xml.impl.report

import me.ugreek85.document.report.IReportPayForm
import me.ugreek85.view.xml.impl.document.XmlBaseRow
import me.ugreek85.view.xml.impl.types.Decimal2
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "ROW")
open class XmlReportPayForm : IReportPayForm, XmlBaseRow() {

    @field:Element(name="PAYFORMCD")
    private var mCode: String = ""

    @field:Element(name="PAYFORMNM")
    private var mName: String = ""

    @field:Element(name="SUM")
    private var mSum: Decimal2 = Decimal2()

    override fun setSum(sum: Double) {
        mSum.setValue(sum)
    }

    override fun getSum(): Double {
        return mSum.getValue().toDouble()
    }

    override fun setCode(code: String) {
        mCode = code
    }

    override fun getCode(): String {
        return mCode
    }

    override fun setName(name: String) {
        mName = name
    }

    override fun getName(): String {
        return mName
    }

    override fun toString(): String {
        return "XmlReportPayForm(mRow=${getRow()}, mCode='$mCode', mName='$mName', mSum=$mSum)"
    }
}