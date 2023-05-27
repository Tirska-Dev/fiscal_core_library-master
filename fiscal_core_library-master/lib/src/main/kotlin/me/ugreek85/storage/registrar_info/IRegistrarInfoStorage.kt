package me.ugreek85.storage.registrar_info

interface IRegistrarInfoStorage {

    fun newInstance(): IRegistrarInfo
    fun get(registrarId: Long): IRegistrarInfo?
    fun update(registrarInfo: IRegistrarInfo)
}