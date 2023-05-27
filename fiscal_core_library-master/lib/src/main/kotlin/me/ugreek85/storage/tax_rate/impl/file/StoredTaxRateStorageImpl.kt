package me.ugreek85.storage.tax_rate.impl.file

import me.ugreek85.extentions.mkdirIfNotExists
import me.ugreek85.storage.common.IdItemAbility
import me.ugreek85.storage.common.SerializeUtil
import me.ugreek85.storage.tax_rate.IStoredTaxRate
import me.ugreek85.storage.tax_rate.IStoredTaxRateStorage
import java.io.File

class StoredTaxRateStorageImpl(workingDirectory: File) : IStoredTaxRateStorage, IdItemAbility<IStoredTaxRate>(
    File(workingDirectory, "tax-rates").apply{ mkdirIfNotExists() },
    IStoredTaxRateStorage::class.java
) {

    override fun loader(file: File) = SerializeUtil.load<StoredTaxRateImpl>(file)


    override fun newInstance(): IStoredTaxRate {
        return StoredTaxRateImpl()
    }

    override fun getTaxRates(): Array<IStoredTaxRate> {
        return getRecords().values.toTypedArray()
    }

    override fun add(taxRate: IStoredTaxRate): Long {
        return addRecord(taxRate)
    }

    override fun update(taxRate: IStoredTaxRate): Boolean {
       return updateRecord(taxRate)
    }

    override fun deleteTaxRate(id: Long): Boolean {
        return deleteRecord(id)
    }

    override fun getTaxRate(id: Long): IStoredTaxRate? {
        return getRecord(id)
    }

    override fun getTaxRateByLetter(letter: String): IStoredTaxRate? {
        return search { it.getLetter() == letter }
    }


}