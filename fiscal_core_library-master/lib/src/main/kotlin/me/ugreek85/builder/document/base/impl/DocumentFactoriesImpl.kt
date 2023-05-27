package me.ugreek85.builder.document.base.impl

import me.ugreek85.builder.document.base.ICommonDocumentFactoriesSet
import me.ugreek85.builder.document.base.IDocumentFactories
import me.ugreek85.builder.document.base.IReceiptDocumentFactoriesSet
import me.ugreek85.builder.document.base.IReportDocumentFactoriesSet

class DocumentFactoriesImpl : IDocumentFactories {

    override fun getDocumentFactoriesSet(): ICommonDocumentFactoriesSet {
        return CommonDocumentFactoriesSetImpl()
    }

    override fun getReceiptDocumentFactoriesSet(): IReceiptDocumentFactoriesSet {
        return ReceiptDocumentFactoriesSetImpl(this)
    }

    override fun getReportDocumentFactoriesSet(): IReportDocumentFactoriesSet {
        return ReportDocumentFactoriesSetImpl(this)
    }
}