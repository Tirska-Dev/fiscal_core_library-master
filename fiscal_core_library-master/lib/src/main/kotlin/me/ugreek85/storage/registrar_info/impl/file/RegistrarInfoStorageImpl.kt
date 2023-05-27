package me.ugreek85.storage.registrar_info.impl.file

import me.ugreek85.storage.common.PathAbility
import me.ugreek85.storage.common.SerializeUtil
import me.ugreek85.storage.registrar_info.IRegistrarInfo
import me.ugreek85.storage.registrar_info.IRegistrarInfoStorage
import me.ugreek85.storage.registrar_info.RegistrarInfoImpl
import java.io.File

class RegistrarInfoStorageImpl(workingDirectory: File) : IRegistrarInfoStorage, PathAbility(workingDirectory) {

    private fun getPath(registrarId: Long, createIfNotExists: Boolean = false): File
    {
        return File(getRootPathForRegistrar(registrarId, createIfNotExists), "info")
    }

    override fun newInstance(): IRegistrarInfo {
        return RegistrarInfoImpl()
    }

    override fun get(registrarId: Long): IRegistrarInfo? {

        val registrarInfoFile = getPath(registrarId)
        if(registrarInfoFile.exists()) return SerializeUtil.load<RegistrarInfoImpl>(registrarInfoFile)
        return null
    }

    override fun update(registrarInfo: IRegistrarInfo) {
        SerializeUtil.save(getPath(registrarInfo.getRegistrarId(), true), registrarInfo)
    }
}