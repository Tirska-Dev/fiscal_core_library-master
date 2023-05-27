package me.ugreek85.view.json.impl.receipt

import me.ugreek85.document.receipt.IExciseLabel
import me.ugreek85.view.json.impl.document.JsonBaseRow
import org.simpleframework.xml.Element

class JsonExciseLabel : IExciseLabel, JsonBaseRow(){

    @field:Element(name="EXCISELABEL")
    private var mLabel: String = ""

    override fun getLabel(): String {
        return mLabel
    }

    override fun setLabel(label: String) {
        mLabel = label
    }
}
