package me.ugreek85.storage.common.impl.file

import me.ugreek85.extentions.mkdirsIfNotExists
import me.ugreek85.storage.common.IStorage
import me.ugreek85.storage.document_info.IDocumentInfoStorage
import me.ugreek85.storage.document_info.impl.file.DocumentInfoStorageImpl
import me.ugreek85.storage.install_info.IInstallInfoStorage
import me.ugreek85.storage.install_info.impl.file.InstallInfoStorageImpl
import me.ugreek85.storage.offline_session.IOfflineSessionStorage
import me.ugreek85.storage.offline_session.impl.file.OfflineSessionStorageImpl
import me.ugreek85.storage.pay_form.IStoredPayFormStorage
import me.ugreek85.storage.pay_form.impl.file.StoredPayFormStorageImpl
import me.ugreek85.storage.registrar_info.IRegistrarInfoStorage
import me.ugreek85.storage.registrar_info.impl.file.RegistrarInfoStorageImpl
import me.ugreek85.storage.registrar_state.IRegistrarStateStorage
import me.ugreek85.storage.registrar_state.impl.file.RegistrarStateStorageImpl
import me.ugreek85.storage.shift.IShiftStorage
import me.ugreek85.storage.shift.impl.file.ShiftStorageImpl
import me.ugreek85.storage.stored_document.impl.file.OfflineStoredDocumentStorageImpl
import me.ugreek85.storage.stored_document.impl.file.OnlineStoredDocumentStorageImpl
import me.ugreek85.storage.tax_rate.IStoredTaxRateStorage
import me.ugreek85.storage.tax_rate.impl.file.StoredTaxRateStorageImpl
import java.io.File

class StorageImpl(private val workingDirectory: File) : IStorage {

    private val dataStorage = DataStorageImpl(workingDirectory)
    private val installInfoStorage = InstallInfoStorageImpl.getInstance(workingDirectory)
    private val taxRateStorage = StoredTaxRateStorageImpl(workingDirectory)
    private val payFormStorage = StoredPayFormStorageImpl(workingDirectory)
    private val registrarStateStorage = RegistrarStateStorageImpl(workingDirectory)
    private val registrarInfoStorage = RegistrarInfoStorageImpl(workingDirectory)
    private val documentInfoStorage = DocumentInfoStorageImpl(dataStorage, OnlineStoredDocumentStorageImpl(workingDirectory))
    private val shiftStorage = ShiftStorageImpl(workingDirectory)
    private val offlineSessionStorage = OfflineSessionStorageImpl(workingDirectory, OfflineStoredDocumentStorageImpl(workingDirectory))


    override fun isStorageEmpty(): Boolean {
        return !installInfoStorage.existInstallId() ||
                payFormStorage.getPaymentForms().isEmpty() ||
                taxRateStorage.getTaxRates().isEmpty()
    }

    override fun init() {

    }

    override fun getInstallInfoStorage(): IInstallInfoStorage {
        return installInfoStorage
    }

    override fun getTaxRateStorage(): IStoredTaxRateStorage {
        return taxRateStorage
    }

    override fun getPayFormStorage(): IStoredPayFormStorage {
        return payFormStorage
    }

    override fun getRegistrarStateStorage(): IRegistrarStateStorage {
        return registrarStateStorage
    }

    override fun getRegistrarInfoStorage(): IRegistrarInfoStorage {
        return registrarInfoStorage
    }

    override fun getDocumentInfoStorage(): IDocumentInfoStorage {
        return documentInfoStorage
    }

    override fun getShiftStorage(): IShiftStorage {
        return shiftStorage
    }

    override fun getOfflineSessionStorage(): IOfflineSessionStorage {
        return offlineSessionStorage
    }
}