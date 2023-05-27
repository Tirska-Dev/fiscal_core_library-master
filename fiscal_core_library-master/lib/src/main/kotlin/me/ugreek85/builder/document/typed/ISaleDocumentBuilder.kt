package me.ugreek85.builder.document.typed

import me.ugreek85.document.common.IDocumentTaxRate
import me.ugreek85.builder.document.typed.common.IBaseDocumentBuilder
import me.ugreek85.builder.document.typed.common.IOfflineAbilityBuilder
import me.ugreek85.document.receipt.IReceiptPayForm
import me.ugreek85.document.receipt.IReceiptProduct
import me.ugreek85.document.receipt.IReceiptTotal

interface ISaleDocumentBuilder :
    IBaseDocumentBuilder<ISaleDocumentBuilder>,
    IOfflineAbilityBuilder<ISaleDocumentBuilder> {

    fun setTotal(total: IReceiptTotal): ISaleDocumentBuilder
    fun setPayForms(payForms: List<IReceiptPayForm>): ISaleDocumentBuilder
    fun setTaxRates(taxRates: List<IDocumentTaxRate>): ISaleDocumentBuilder
    fun setProducts(products: List<IReceiptProduct>): ISaleDocumentBuilder
}