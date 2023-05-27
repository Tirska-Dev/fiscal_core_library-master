package me.ugreek85.builder.document.typed.common.impl

import me.ugreek85.builder.document.offline_fiscal_number.impl.CheckNumberGenerationStrategyImpl
import me.ugreek85.builder.document.base.IDocumentFactories
import me.ugreek85.builder.document.base.impl.DocumentFactoriesImpl
import me.ugreek85.builder.document.offline_fiscal_number.IOfflineFiscalNumberBuilder
import me.ugreek85.builder.document.typed.*
import me.ugreek85.builder.document.typed.common.ITypedDocumentBuilderFactory
import me.ugreek85.builder.document.typed.impl.*
import me.ugreek85.builder.document.offline_fiscal_number.impl.OfflineFiscalNumberBuilderImpl

class TypedDocumentBuilderFactoryImpl private constructor(

    private val mDocumentFactories: IDocumentFactories,
    private val mOfflineFiscalNumberBuilder: IOfflineFiscalNumberBuilder,

): ITypedDocumentBuilderFactory {

    companion object{
        fun newInstance(): ITypedDocumentBuilderFactory
        {
            return TypedDocumentBuilderFactoryImpl(
                DocumentFactoriesImpl(),
                OfflineFiscalNumberBuilderImpl(CheckNumberGenerationStrategyImpl()),
            )
        }
    }

    override fun newBeginOfflineDocumentBuilder(): IBeginOfflineDocumentBuilder {
        return BeginOfflineDocumentBuilderImpl(mDocumentFactories, mOfflineFiscalNumberBuilder)
    }

    override fun newFinishOfflineDocumentBuilder(): IFinishOfflineDocumentBuilder {
        return FinishOfflineDocumentBuilderImpl(mDocumentFactories, mOfflineFiscalNumberBuilder)
    }

    override fun newOpenShiftDocumentBuilder(): IOpenShiftDocumentBuilder {
        return OpenShiftDocumentBuilderImpl(mDocumentFactories, mOfflineFiscalNumberBuilder)
    }

    override fun newCloseShiftDocumentBuilder(): ICloseShiftDocumentBuilder {
        return CloseShiftDocumentBuilderImpl(mDocumentFactories, mOfflineFiscalNumberBuilder)
    }

    override fun newZReportDocumentBuilder(): IZReportDocumentBuilder {
        TODO("Not yet implemented")
    }

    override fun newSaleDocumentBuilder(): ISaleDocumentBuilder {
        TODO("Not yet implemented")
    }

    override fun newReturnDocumentBuilder(): IReturnDocumentBuilder {
        TODO("Not yet implemented")
    }

    override fun newCancelDocumentBuilder(): ICancelDocumentBuilder {
        return CancelDocumentBuilderImpl(mDocumentFactories, mOfflineFiscalNumberBuilder)
    }

    override fun newServiceInputDocumentBuilder(): IServiceInputDocumentBuilder {
        return ServiceInputDocumentBuilderImpl(mDocumentFactories, mOfflineFiscalNumberBuilder)
    }

    override fun newServiceOutputDocumentBuilder(): IServiceOutputDocumentBuilder {
        return ServiceOutputDocumentBuilderImpl(mDocumentFactories, mOfflineFiscalNumberBuilder)
    }
}