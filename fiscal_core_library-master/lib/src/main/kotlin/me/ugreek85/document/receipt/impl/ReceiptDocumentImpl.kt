package me.ugreek85.document.receipt.impl

import me.ugreek85.builder.document.base.IDocumentFactories
import me.ugreek85.document.common.DocumentType
import me.ugreek85.document.common.IDocumentHeader
import me.ugreek85.document.common.IDocumentTaxRate
import me.ugreek85.document.common.impl.BaseDocumentImpl
import me.ugreek85.document.receipt.IReceiptDocument
import me.ugreek85.document.receipt.IReceiptPayForm
import me.ugreek85.document.receipt.IReceiptProduct
import me.ugreek85.document.receipt.IReceiptTotal
import me.ugreek85.utils.DocumentCopyUtil

class ReceiptDocumentImpl(
    private val mDocumentFactories: IDocumentFactories
)
    : BaseDocumentImpl(mDocumentFactories), IReceiptDocument
{
    private var mTotal: IReceiptTotal? = null
    private var mPayForms: List<IReceiptPayForm>? = null
    private var mTaxRates: List<IDocumentTaxRate>? = null
    private var mProducts: List<IReceiptProduct>? = null

    override fun setTotal(total: IReceiptTotal?) {
        mTotal = DocumentCopyUtil.copyObject(IReceiptTotal::class.java, total){
            mDocumentFactories.getReceiptDocumentFactoriesSet().newReceiptTotal()
        }
    }

    override fun getTotal(): IReceiptTotal? {
        return mTotal
    }

    override fun setPayForms(payForms: List<IReceiptPayForm>?) {
        mPayForms = DocumentCopyUtil.copyList(IReceiptPayForm::class.java, payForms){
            mDocumentFactories.getReceiptDocumentFactoriesSet().newReceiptPayForm()
        }
    }

    override fun getPayForms(): List<IReceiptPayForm>? {
        return mPayForms
    }

    override fun setTaxRates(taxRates: List<IDocumentTaxRate>?) {
        mTaxRates = DocumentCopyUtil.copyList(IDocumentTaxRate::class.java, taxRates){
            mDocumentFactories.getDocumentFactoriesSet().newDocumentTaxRate()
        }
    }

    override fun getTaxRates(): List<IDocumentTaxRate>? {
        return mTaxRates
    }

    override fun setProducts(products: List<IReceiptProduct>?) {
        mProducts = DocumentCopyUtil.copyList(IReceiptProduct::class.java, products){
            mDocumentFactories.getReceiptDocumentFactoriesSet().newReceiptProduct()
        }
    }

    override fun getProducts(): List<IReceiptProduct>? {
        return mProducts
    }
}