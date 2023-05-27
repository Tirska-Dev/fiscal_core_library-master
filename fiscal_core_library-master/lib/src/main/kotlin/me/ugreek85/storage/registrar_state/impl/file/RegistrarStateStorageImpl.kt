package me.ugreek85.storage.registrar_state.impl.file

import me.ugreek85.storage.common.PathAbility
import me.ugreek85.storage.common.SerializeUtil
import me.ugreek85.storage.registrar_state.IRegistrarState
import me.ugreek85.storage.registrar_state.IRegistrarStateStorage
import java.io.File

class RegistrarStateStorageImpl(workingDirectory: File) :
    IRegistrarStateStorage, PathAbility(workingDirectory) {

    private fun getPath(registrarId: Long, createIfNotExists: Boolean = false): File
    {
        return File(getRootPathForRegistrar(registrarId, createIfNotExists), "state")
    }

    override fun newInstance(): IRegistrarState {
        return RegistrarStateImpl(getWorkingDirectory())
    }

    override fun get(registrarId: Long): IRegistrarState? {
        val stateFile = getPath(registrarId)
        if(stateFile.exists()) return SerializeUtil.load<RegistrarStateImpl>(stateFile)
        return null
    }

    override fun update(registrarState: IRegistrarState) {
        SerializeUtil.save(getPath(registrarState.getRegistrarId(), true), registrarState)
    }
}