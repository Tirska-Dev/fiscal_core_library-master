package me.ugreek85.builder.document.typed

import me.ugreek85.document.common.IDocumentTaxRate
import me.ugreek85.builder.document.typed.common.IBaseDocumentBuilder
import me.ugreek85.builder.document.typed.common.IOfflineAbilityBuilder
import me.ugreek85.document.receipt.IReceiptPayForm
import me.ugreek85.document.receipt.IReceiptProduct
import me.ugreek85.document.receipt.IReceiptTotal

interface IReturnDocumentBuilder :
    IBaseDocumentBuilder<IReturnDocumentBuilder>,
    IOfflineAbilityBuilder<ICloseShiftDocumentBuilder> {

    fun setFiscalNumberForReturn(fiscalNumberForReturn: String): IReturnDocumentBuilder

    fun setTotal(total: IReceiptTotal): IReturnDocumentBuilder
    fun setPayForms(payForms: List<IReceiptPayForm>): IReturnDocumentBuilder
    fun setTaxRates(taxRates: List<IDocumentTaxRate>): IReturnDocumentBuilder
    fun setProducts(products: List<IReceiptProduct>): IReturnDocumentBuilder
}