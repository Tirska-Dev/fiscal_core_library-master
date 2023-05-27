package me.ugreek85.document.report.impl

import me.ugreek85.builder.document.base.IDocumentFactories
import me.ugreek85.document.common.impl.BaseDocumentImpl
import me.ugreek85.document.report.IReportCashTotal
import me.ugreek85.document.report.IReportDocument
import me.ugreek85.document.report.IReportTotal
import me.ugreek85.utils.DocumentCopyUtil
import kotlin.properties.Delegates

class ReportDocumentImpl(
    private val mDocumentFactories: IDocumentFactories
)
    : BaseDocumentImpl(mDocumentFactories), IReportDocument
{
    private var mTotalsBySale: IReportTotal? = null
    private var mTotalsByReturn: IReportTotal? = null
    private var mServiceInputSum by Delegates.notNull<Double>()
    private var mServiceOutputSum by Delegates.notNull<Double>()
    private var mTotalsByCash: IReportCashTotal? = null

    override fun setTotalsBySale(totals: IReportTotal?) {
        mTotalsBySale = DocumentCopyUtil.copyObject(IReportTotal::class.java, totals) {
            mDocumentFactories.getReportDocumentFactoriesSet().newReportTotal()
        }
    }

    override fun getTotalsBySale(): IReportTotal? {
        return mTotalsBySale
    }

    override fun setTotalsByReturn(totals: IReportTotal?) {
        mTotalsByReturn = DocumentCopyUtil.copyObject(IReportTotal::class.java, totals){
            mDocumentFactories.getReportDocumentFactoriesSet().newReportTotal()
        }
    }

    override fun getTotalsByReturn(): IReportTotal? {
        return mTotalsByReturn
    }

    override fun setServiceInputSum(sum: Double) {
        mServiceInputSum = sum
    }

    override fun getServiceInputSum(): Double {
        return mServiceInputSum
    }

    override fun setServiceOutputSum(sum: Double) {
        mServiceOutputSum = sum
    }

    override fun getServiceOutputSum(): Double {
        return mServiceOutputSum
    }

    override fun setTotalsByCash(totals: IReportCashTotal?) {
        mTotalsByCash = DocumentCopyUtil.copyObject(IReportCashTotal::class.java, totals) {
            mDocumentFactories.getReportDocumentFactoriesSet().newReportCashTotal()
        }
    }

    override fun getTotalsByCash(): IReportCashTotal? {
        return mTotalsByCash
    }
}