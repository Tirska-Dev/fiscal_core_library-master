package me.ugreek85.builder.document.base

interface IDocumentFactories {

    fun getDocumentFactoriesSet(): ICommonDocumentFactoriesSet
    fun getReceiptDocumentFactoriesSet(): IReceiptDocumentFactoriesSet
    fun getReportDocumentFactoriesSet(): IReportDocumentFactoriesSet
}