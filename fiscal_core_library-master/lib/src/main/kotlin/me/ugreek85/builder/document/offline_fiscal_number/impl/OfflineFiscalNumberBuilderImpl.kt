package me.ugreek85.builder.document.offline_fiscal_number.impl

import me.ugreek85.builder.document.offline_fiscal_number.ICheckNumberGenerationStrategy
import me.ugreek85.builder.document.offline_fiscal_number.IOfflineFiscalNumberBuilder
import kotlin.properties.Delegates

class OfflineFiscalNumberBuilderImpl(
    private val checkNumberGenerationStrategy: ICheckNumberGenerationStrategy
) : IOfflineFiscalNumberBuilder {

    private lateinit var mOfflineSessionId: String
    private var mOfflineDocumentNumber by Delegates.notNull<Long>()
    private lateinit var mOfflineSeed: String
    private lateinit var mDate: String
    private lateinit var mTime: String
    private var mDocumentNumber by Delegates.notNull<Long>()
    private var mRegistrarId by Delegates.notNull<Long>()
    private var mRegistrarLocalNumber by Delegates.notNull<Long>()
    private var mSum: Double? = null
    private var mPreviousDocumentHash: String? = null

    override fun setOfflineSessionId(offlineSessionId: String): IOfflineFiscalNumberBuilder {
        mOfflineSessionId = offlineSessionId
        return this
    }

    override fun setOfflineDocumentNumber(offlineDocumentNumber: Long): IOfflineFiscalNumberBuilder {
        mOfflineDocumentNumber = offlineDocumentNumber
        return this
    }

    override fun setOfflineSeed(offlineSeed: String): IOfflineFiscalNumberBuilder {
        mOfflineSeed = offlineSeed
        return this
    }

    override fun setDate(date: String): IOfflineFiscalNumberBuilder {
        mDate = date
        return this
    }

    override fun setTime(time: String): IOfflineFiscalNumberBuilder {
        mTime = time
        return this
    }

    override fun setDocumentNumber(documentNumber: Long): IOfflineFiscalNumberBuilder {
        mDocumentNumber = documentNumber
        return this
    }

    override fun setRegistrarId(registrarId: Long): IOfflineFiscalNumberBuilder {
        mRegistrarId = registrarId
        return this
    }

    override fun setRegistrarLocalNumber(registrarLocalNumber: Long): IOfflineFiscalNumberBuilder {
        mRegistrarLocalNumber = registrarLocalNumber
        return this
    }

    override fun setSum(sum: Double?): IOfflineFiscalNumberBuilder {
        mSum = sum
        return this
    }

    override fun setPreviousDocumentHash(previousDocumentHash: String?): IOfflineFiscalNumberBuilder {
        mPreviousDocumentHash = previousDocumentHash
        return this
    }

    override fun build(): String {

        val checkNumber = checkNumberGenerationStrategy.additionalCheckNumberHandler(
            checkNumberGenerationStrategy.createCheckNumber(
                mOfflineSeed, mDate, mTime, mDocumentNumber, mRegistrarId, mRegistrarLocalNumber, mSum, mPreviousDocumentHash
            )
        )

        return "${mOfflineSessionId}.${mOfflineDocumentNumber}.$checkNumber"
    }
}