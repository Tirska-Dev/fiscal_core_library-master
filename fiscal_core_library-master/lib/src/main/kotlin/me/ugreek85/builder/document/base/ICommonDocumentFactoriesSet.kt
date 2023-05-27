package me.ugreek85.builder.document.base

import me.ugreek85.document.common.IDocumentHeader
import me.ugreek85.document.common.IDocumentTaxRate

interface ICommonDocumentFactoriesSet {

    fun newDocumentHeader(): IDocumentHeader
    fun newDocumentTaxRate(): IDocumentTaxRate
}