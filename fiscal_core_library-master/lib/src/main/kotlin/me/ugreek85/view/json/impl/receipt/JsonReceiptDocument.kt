package me.ugreek85.view.json.impl.receipt

import com.google.gson.annotations.SerializedName
import me.ugreek85.document.common.*
import me.ugreek85.document.receipt.IReceiptDocument
import me.ugreek85.document.receipt.IReceiptPayForm
import me.ugreek85.document.receipt.IReceiptProduct
import me.ugreek85.document.receipt.IReceiptTotal
import me.ugreek85.utils.DocumentCopyUtil
import me.ugreek85.view.json.impl.document.JsonBaseDocument
import me.ugreek85.view.json.impl.document.JsonDocumentTaxRate

class JsonReceiptDocument: IReceiptDocument, JsonBaseDocument() {

    // for sale or refund
    @SerializedName("total")
    private var _total: Double? = null

    // for serviceInput or serviceOutput
    @SerializedName("sum")
    private var _sum: Double? = null

    @SerializedName("commissionSum")
    private var _commissionSum: Double? = null

    @SerializedName("totals")
    private var mTotal: IReceiptTotal? = null


    @SerializedName("payments")
    private var mPayForms: List<JsonReceiptDocumentPayForm>? = null

    @SerializedName("taxes")
    private var mTaxRates: List<JsonDocumentTaxRate>? = null

    @SerializedName("products")
    private var mProducts: List<JsonReceiptProduct>? = null


    override fun setTotal(total: IReceiptTotal?) {
        mTotal = DocumentCopyUtil.copyObject(IReceiptTotal::class.java, total){
            JsonReceiptTotal()
        }

        mTotal?.let {
            it.getSum().let { value ->

                if(getDocumentType() == DocumentType.Sale
                    || getDocumentType() == DocumentType.Return
                    || getDocumentType() == DocumentType.CashWithdrawal) {
                    /*if (value != 0.0) */_total = value
                }
                else if(getDocumentType() == DocumentType.ServiceInput || getDocumentType() == DocumentType.ServiceOutput) {
                    /*if (value != 0.0) */_sum = value
                }
            }

            it.getCommissionSum()?.let{ value ->

                if(getDocumentType() == DocumentType.CashWithdrawal) {
                    _commissionSum = value
                }
            }
        }
    }

    override fun getTotal(): IReceiptTotal? {
        return mTotal
    }

    override fun setPayForms(payForms: List<IReceiptPayForm>?) {
        mPayForms = DocumentCopyUtil.copyList(IReceiptPayForm::class.java, payForms){
            JsonReceiptDocumentPayForm()
        }
    }

    override fun getPayForms(): List<IReceiptPayForm>? {
        return mPayForms
    }

    override fun setTaxRates(taxRates: List<IDocumentTaxRate>?) {
        mTaxRates = DocumentCopyUtil.copyList(IDocumentTaxRate::class.java, taxRates){
            JsonDocumentTaxRate()
        }
    }

    override fun getTaxRates(): List<IDocumentTaxRate>? {
        return mTaxRates
    }

    override fun setProducts(products: List<IReceiptProduct>?) {
        mProducts = DocumentCopyUtil.copyList(IReceiptProduct::class.java, products){
            JsonReceiptProduct()
        }
    }

    override fun getProducts(): List<IReceiptProduct>? {
        return mProducts
    }

}