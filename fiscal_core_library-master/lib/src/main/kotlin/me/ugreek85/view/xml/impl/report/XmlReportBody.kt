package me.ugreek85.view.xml.impl.report

import me.ugreek85.view.xml.impl.types.Decimal2
import org.simpleframework.xml.Element

class XmlReportBody {

    @field:Element(name="SERVICEINPUT", required = false)
    private var mServiceInputSum = Decimal2()

    @field:Element(name="SERVICEOUTPUT", required = false)
    private var mServiceOutputSum = Decimal2()

    fun setServiceInputSum(sum: Double) {
        mServiceInputSum.setValue(sum)
    }

    fun getServiceInputSum(): Double {
        return mServiceInputSum.getValue().toDouble()
    }

    fun setServiceOutputSum(sum: Double) {
        mServiceOutputSum.setValue(sum)
    }

     fun getServiceOutputSum(): Double {
         return mServiceOutputSum.getValue().toDouble()
    }
}
