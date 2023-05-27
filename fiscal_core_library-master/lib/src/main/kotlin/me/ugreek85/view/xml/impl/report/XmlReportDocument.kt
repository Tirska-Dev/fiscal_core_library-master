package me.ugreek85.view.xml.impl.report

import me.ugreek85.document.common.IDocumentHeader
import me.ugreek85.document.report.IReportCashTotal
import me.ugreek85.document.report.IReportDocument
import me.ugreek85.document.report.IReportTotal
import me.ugreek85.utils.CopyObjectUtil
import me.ugreek85.utils.DocumentCopyUtil
import me.ugreek85.view.xml.impl.document.XmlBaseDocument
import me.ugreek85.view.xml.impl.document.XmlDocumentHeader
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name="ZREP")
class XmlReportDocument : IReportDocument, XmlBaseDocument() {

    @field:Element(name="ZREPHEAD")
    private lateinit var mDocumentHeader: XmlDocumentHeader

    @field:Element(name="ZREPREALIZ", required = false)
    private var mTotalsBySale: XmlReportTotal? = null

    @field:Element(name="ZREPRETURN", required = false)
    private var mTotalsByReturn: XmlReportTotal? = null

    @field:Element(name="ZREPCASH", required = false)
    private var mTotalsByCash: XmlReportCashTotal? = null

    @field:Element(name="ZREPBODY", required = false)
    private var mReportBody = XmlReportBody()

    override fun setTotalsBySale(totals: IReportTotal?) {

        mTotalsBySale = DocumentCopyUtil.copyObject2(IReportTotal::class.java, totals){
            XmlReportTotal()
        }
    }

    override fun getTotalsBySale(): IReportTotal? {
        return mTotalsBySale
    }

    override fun setTotalsByReturn(totals: IReportTotal?) {
        mTotalsByReturn = DocumentCopyUtil.copyObject2(IReportTotal::class.java, totals){
            XmlReportTotal()
        }
    }

    override fun getTotalsByReturn(): IReportTotal? {
        return mTotalsByReturn
    }

    override fun setServiceInputSum(sum: Double) {
        mReportBody.setServiceInputSum(sum)
    }

    override fun getServiceInputSum(): Double {
        return mReportBody.getServiceInputSum()
    }

    override fun setServiceOutputSum(sum: Double) {
        mReportBody.setServiceOutputSum(sum)
    }

    override fun getServiceOutputSum(): Double {
        return mReportBody.getServiceOutputSum()
    }

    override fun setTotalsByCash(totals: IReportCashTotal?) {
        mTotalsByCash = DocumentCopyUtil.copyObject2(IReportCashTotal::class.java, totals){
            XmlReportCashTotal()
        }
    }

    override fun getTotalsByCash(): IReportCashTotal? {
        return mTotalsByCash
    }

    override fun getDocumentHeader(): IDocumentHeader {
        return mDocumentHeader
    }

    override fun setDocumentHeader(documentHeader: IDocumentHeader) {
        mDocumentHeader = XmlDocumentHeader()
        CopyObjectUtil.copyByInterface(IDocumentHeader::class.java, documentHeader, mDocumentHeader)
    }

    override fun toString(): String {
        return "XmlReportDocument(mDocumentHeader=$mDocumentHeader, mTotalsBySale=$mTotalsBySale, mTotalsByReturn=$mTotalsByReturn, mReportBody=$mReportBody)"
    }

}
