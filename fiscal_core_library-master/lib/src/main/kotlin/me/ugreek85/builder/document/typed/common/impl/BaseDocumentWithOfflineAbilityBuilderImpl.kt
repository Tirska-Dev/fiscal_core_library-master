package me.ugreek85.builder.document.typed.common.impl

import me.ugreek85.document.common.IDocumentHeader
import me.ugreek85.builder.document.typed.common.IOfflineAbilityBuilder
import me.ugreek85.builder.document.offline_fiscal_number.IOfflineFiscalNumberBuilder
import me.ugreek85.builder.document.base.IDocumentFactories
import me.ugreek85.document.common.DocumentType

@Suppress("UNCHECKED_CAST")
abstract class BaseDocumentWithOfflineAbilityBuilderImpl<T>(
    documentFactories: IDocumentFactories,
    offlineFiscalNumberBuilder: IOfflineFiscalNumberBuilder
    ) :
    BaseDocumentBuilderImpl<T>(documentFactories, offlineFiscalNumberBuilder),
    IOfflineAbilityBuilder<T>

{
    private var mOffline: Boolean? = null
    private var mPreviousDocumentHash: String? = null

    override fun setOffline(offline: Boolean): T {
        this.mOffline = offline
        return this as T
    }

    override fun setPreviousDocumentHash(hash: String?): T {
        this.mPreviousDocumentHash = hash
        return this as T
    }

    private fun createOfflineFiscalNumber(documentHeader: IDocumentHeader): String
    {
        val builderIOfflineFiscalNumberBuilder = addingAdditionalParamsToOfflineFiscalNumberBuilder(getOfflineFiscalNumberBuilder())

        val registrarState = getRegistrarState()

        builderIOfflineFiscalNumberBuilder.setOfflineSessionId(registrarState.getOfflineState()!!.getSessionId()!!)
        builderIOfflineFiscalNumberBuilder.setOfflineDocumentNumber(registrarState.getOfflineState()!!.getNextDocumentNumber()!!)

        builderIOfflineFiscalNumberBuilder.setOfflineSeed(registrarState.getOfflineState()!!.getSeed()!!)
        builderIOfflineFiscalNumberBuilder.setDate(documentHeader.getDate())
        builderIOfflineFiscalNumberBuilder.setTime(documentHeader.getTime())
        builderIOfflineFiscalNumberBuilder.setDocumentNumber(documentHeader.getDocumentNumber())
        builderIOfflineFiscalNumberBuilder.setRegistrarId(documentHeader.getRegistrarId())
        builderIOfflineFiscalNumberBuilder.setRegistrarLocalNumber(documentHeader.getRegistrarLocalNumber())
        builderIOfflineFiscalNumberBuilder.setPreviousDocumentHash(mPreviousDocumentHash)
        return builderIOfflineFiscalNumberBuilder.build()
    }

    override fun buildHeader(documentType: DocumentType): IDocumentHeader {

        val documentHeader = super.buildHeader(documentType)

        mOffline?.let {

            documentHeader.apply {

                setOffline(it)
                setPreviousDocumentHash(mPreviousDocumentHash)
                setFiscalNumber(createOfflineFiscalNumber(this))
            }
        }

        return documentHeader
    }

    protected open fun addingAdditionalParamsToOfflineFiscalNumberBuilder(offlineFiscalNumberBuilder: IOfflineFiscalNumberBuilder): IOfflineFiscalNumberBuilder
    {
        return offlineFiscalNumberBuilder
    }
}