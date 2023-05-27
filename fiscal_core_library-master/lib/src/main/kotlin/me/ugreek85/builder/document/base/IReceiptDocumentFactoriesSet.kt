package me.ugreek85.builder.document.base

import me.ugreek85.document.receipt.*

interface IReceiptDocumentFactoriesSet {

    fun newReceiptDocument(): IReceiptDocument
    fun newReceiptProduct(): IReceiptProduct
    fun newReceiptTotal(): IReceiptTotal
    fun newReceiptPayForm(): IReceiptPayForm
    fun newExciseLabel(): IExciseLabel
    fun newPaymentDetails(): IPaymentDetails
}