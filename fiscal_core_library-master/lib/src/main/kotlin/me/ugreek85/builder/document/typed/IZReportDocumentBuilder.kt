package me.ugreek85.builder.document.typed

import me.ugreek85.builder.document.typed.common.IBaseDocumentBuilder
import me.ugreek85.builder.document.typed.common.IOfflineAbilityBuilder
import me.ugreek85.document.report.IReportTotal

interface IZReportDocumentBuilder :
    IBaseDocumentBuilder<IZReportDocumentBuilder>,
    IOfflineAbilityBuilder<IZReportDocumentBuilder> {

    fun setTotalsBySale(totals: IReportTotal?): IZReportDocumentBuilder
    fun setTotalsByReturn(totals: IReportTotal?): IZReportDocumentBuilder
    fun setServiceInputSum(sum: Double): IZReportDocumentBuilder
    fun setServiceOutputSum(sum: Double): IZReportDocumentBuilder
}