package me.ugreek85.storage.tax_rate

interface IStoredTaxRateStorage {

    fun newInstance(): IStoredTaxRate
    fun getTaxRates(): Array<IStoredTaxRate>
    fun add(taxRate: IStoredTaxRate): Long
    fun update(taxRate: IStoredTaxRate): Boolean
    fun deleteTaxRate(id: Long): Boolean
    fun getTaxRate(id: Long): IStoredTaxRate?
    fun getTaxRateByLetter(letter: String): IStoredTaxRate?
}