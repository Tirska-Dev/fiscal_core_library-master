package me.ugreek85.view.json.impl.document

import me.ugreek85.document.common.IRow

open class JsonBaseRow : IRow {

    @Transient
    private var mRow: Int = 1

    override fun setRow(row: Int){
        mRow = row
    }

    override fun getRow() = mRow
}