package me.ugreek85.builder.document.typed.common

import me.ugreek85.builder.document.typed.*

interface ITypedDocumentBuilderFactory {

    fun newBeginOfflineDocumentBuilder(): IBeginOfflineDocumentBuilder
    fun newFinishOfflineDocumentBuilder(): IFinishOfflineDocumentBuilder

    fun newOpenShiftDocumentBuilder(): IOpenShiftDocumentBuilder
    fun newCloseShiftDocumentBuilder(): ICloseShiftDocumentBuilder
    fun newZReportDocumentBuilder(): IZReportDocumentBuilder

    fun newSaleDocumentBuilder(): ISaleDocumentBuilder
    fun newReturnDocumentBuilder(): IReturnDocumentBuilder
    fun newCancelDocumentBuilder(): ICancelDocumentBuilder

    fun newServiceInputDocumentBuilder(): IServiceInputDocumentBuilder
    fun newServiceOutputDocumentBuilder(): IServiceOutputDocumentBuilder
}