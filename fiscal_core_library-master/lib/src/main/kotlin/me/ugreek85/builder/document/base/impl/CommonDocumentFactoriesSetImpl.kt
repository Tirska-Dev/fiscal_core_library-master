package me.ugreek85.builder.document.base.impl

import me.ugreek85.builder.document.base.ICommonDocumentFactoriesSet
import me.ugreek85.document.common.IDocumentHeader
import me.ugreek85.document.common.IDocumentTaxRate
import me.ugreek85.document.common.impl.DocumentHeaderImpl
import me.ugreek85.document.common.impl.DocumentTaxRateImpl

class CommonDocumentFactoriesSetImpl : ICommonDocumentFactoriesSet {

    override fun newDocumentHeader(): IDocumentHeader {
        return DocumentHeaderImpl()
    }

    override fun newDocumentTaxRate(): IDocumentTaxRate {
        return DocumentTaxRateImpl()
    }

}