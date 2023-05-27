package me.ugreek85.storage.register

interface IRegistersStorage {

    fun add(registrarId: Long, record: IRegisterRecord)
    fun setCanceledByFiscalNumber(registrarId: Long, fiscalNumber: String)
    fun getAll(registrarId: Long): Map<String, Double>
    fun reset(registrarId: Long)
}