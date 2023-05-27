package me.ugreek85.storage.common

import me.ugreek85.storage.document_info.IDocumentInfoStorage
import me.ugreek85.storage.install_info.IInstallInfoStorage
import me.ugreek85.storage.offline_session.IOfflineSessionStorage
import me.ugreek85.storage.pay_form.IStoredPayFormStorage
import me.ugreek85.storage.registrar_info.IRegistrarInfoStorage
import me.ugreek85.storage.registrar_state.IRegistrarStateStorage
import me.ugreek85.storage.shift.IShiftStorage
import me.ugreek85.storage.tax_rate.IStoredTaxRateStorage

interface IStorage {

    // Does need load data to storage
    fun isStorageEmpty() : Boolean
    fun init()

    fun getInstallInfoStorage(): IInstallInfoStorage

    fun getTaxRateStorage(): IStoredTaxRateStorage
    fun getPayFormStorage(): IStoredPayFormStorage

    fun getRegistrarStateStorage(): IRegistrarStateStorage
    fun getRegistrarInfoStorage(): IRegistrarInfoStorage

    fun getDocumentInfoStorage(): IDocumentInfoStorage
    fun getShiftStorage(): IShiftStorage
    fun getOfflineSessionStorage(): IOfflineSessionStorage


}