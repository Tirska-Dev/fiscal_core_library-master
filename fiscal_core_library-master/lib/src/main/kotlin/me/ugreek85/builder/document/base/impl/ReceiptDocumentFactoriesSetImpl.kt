package me.ugreek85.builder.document.base.impl

import me.ugreek85.builder.document.base.IDocumentFactories
import me.ugreek85.builder.document.base.IReceiptDocumentFactoriesSet
import me.ugreek85.document.receipt.*
import me.ugreek85.document.receipt.impl.*

class ReceiptDocumentFactoriesSetImpl(
    private val mDocumentFactories: IDocumentFactories
) : IReceiptDocumentFactoriesSet {

    override fun newReceiptDocument(): IReceiptDocument {
        return ReceiptDocumentImpl(mDocumentFactories)
    }

    override fun newReceiptProduct(): IReceiptProduct {
        return ReceiptProductImpl(this)
    }

    override fun newReceiptTotal(): IReceiptTotal {
        return ReceiptTotalImpl()
    }

    override fun newReceiptPayForm(): IReceiptPayForm {
        return ReceiptDocumentPayFormImpl(this)
    }

    override fun newExciseLabel(): IExciseLabel {
        return ExciseLabelImpl()
    }

    override fun newPaymentDetails(): IPaymentDetails {
        return PaymentDetailsImpl()
    }
}