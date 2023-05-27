package me.ugreek85.storage.registrar_state

interface IRegistrarStateStorage {

    fun newInstance(): IRegistrarState

    fun get(registrarId: Long): IRegistrarState?
    fun update(registrarState: IRegistrarState)
}