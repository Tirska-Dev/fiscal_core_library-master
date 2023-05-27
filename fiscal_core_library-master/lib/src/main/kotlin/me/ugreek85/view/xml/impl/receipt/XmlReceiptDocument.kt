package me.ugreek85.view.xml.impl.receipt

import me.ugreek85.document.common.IDocumentHeader
import me.ugreek85.document.common.IDocumentTaxRate
import me.ugreek85.document.receipt.IReceiptDocument
import me.ugreek85.document.receipt.IReceiptPayForm
import me.ugreek85.document.receipt.IReceiptProduct
import me.ugreek85.document.receipt.IReceiptTotal
import me.ugreek85.utils.CopyObjectUtil
import me.ugreek85.utils.DocumentCopyUtil
import me.ugreek85.view.xml.impl.document.XmlBaseDocument
import me.ugreek85.view.xml.impl.document.XmlDocumentHeader
import me.ugreek85.view.xml.impl.document.XmlDocumentTaxRate
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.util.ArrayList

@Root(name="CHECK", strict = false)
class XmlReceiptDocument: IReceiptDocument, XmlBaseDocument() {

    @field:Element(name="CHECKHEAD")
    private lateinit var mDocumentHeader: XmlDocumentHeader

    @field:Element(name="CHECKTOTAL", required = false)
    private var mTotal: XmlReceiptTotal? = null

    @field:ElementList(name = "CHECKPAY", required = false)
    var mPayForms: ArrayList<XmlReceiptPayForm>? = null

    @field:ElementList(name = "CHECKTAX", required = false)
    var mTaxRates: ArrayList<XmlDocumentTaxRate>? = null

    @field:ElementList(name = "CHECKBODY", required = false)
    var mProducts: ArrayList<XmlReceiptProduct>? = null


    override fun setTotal(total: IReceiptTotal?) {
        mTotal = DocumentCopyUtil.copyObject(IReceiptTotal::class.java, total){
            XmlReceiptTotal()
        } as XmlReceiptTotal
    }

    override fun getTotal(): IReceiptTotal? {
        return mTotal
    }

    override fun setPayForms(payForms: List<IReceiptPayForm>?) {

        mPayForms = DocumentCopyUtil.copyArrayList(IReceiptPayForm::class.java, payForms){
            XmlReceiptPayForm()
        }
    }

    override fun getPayForms(): List<IReceiptPayForm>? {
        return mPayForms
    }

    override fun setTaxRates(taxRates: List<IDocumentTaxRate>?) {

        mTaxRates = DocumentCopyUtil.copyArrayList(IDocumentTaxRate::class.java, taxRates){
            XmlDocumentTaxRate()
        }
    }

    override fun getTaxRates(): List<IDocumentTaxRate>? {
        return mTaxRates
    }

    override fun setProducts(products: List<IReceiptProduct>?) {

        mProducts = DocumentCopyUtil.copyArrayList(IReceiptProduct::class.java, products){
            XmlReceiptProduct()
        }
    }

    override fun getProducts(): List<IReceiptProduct>? {
        return mProducts
    }

    override fun getDocumentHeader(): IDocumentHeader {
        return mDocumentHeader
    }

    override fun setDocumentHeader(documentHeader: IDocumentHeader) {
        mDocumentHeader = XmlDocumentHeader()
        CopyObjectUtil.copyByInterface(IDocumentHeader::class.java, documentHeader, mDocumentHeader)
    }

    override fun toString(): String {
        return "XmlReceiptDocument(mDocumentHeader=$mDocumentHeader, mTotal=$mTotal, mPayForms=$mPayForms, mTaxRates=$mTaxRates, mProducts=$mProducts)"
    }

}