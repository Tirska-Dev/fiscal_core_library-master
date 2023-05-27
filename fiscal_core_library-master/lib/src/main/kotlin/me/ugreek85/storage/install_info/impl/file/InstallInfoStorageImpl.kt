package me.ugreek85.storage.install_info.impl.file

import me.ugreek85.storage.install_info.IInstallInfoStorage
import java.io.File

class InstallInfoStorageImpl private constructor(
    private val workingDirectory: File
) : IInstallInfoStorage {

    private var clientId: String? = null
    private var installId: String? = null



    init {

        clientId = getClientId()
        installId = getInstallId()

    }

    @Synchronized override fun getClientId(): String? {
        return clientId ?: load(Companion.CLIENT_ID_KEY)
    }

    @Synchronized override fun setClientId(clientId: String) {
        this.clientId = clientId
        save(Companion.CLIENT_ID_KEY, clientId)
    }

    override fun existClientId(): Boolean {
        return getClientId() != null
    }

    @Synchronized override fun getInstallId(): String? {
        return installId ?: load(INSTALL_ID_KEY)
    }

    @Synchronized override fun setInstallId(installId: String) {
        this.installId = installId
        save(INSTALL_ID_KEY, installId)
    }

    override fun existInstallId(): Boolean {
        return getInstallId() != null
    }

    private fun load(key: String): String?
    {
        val file = File(workingDirectory, key)
        if(!file.exists()) return null
        return file.readText(Charsets.UTF_8)
    }

    private fun save(key: String, value: String)
    {
        File(workingDirectory, key).writeText(value, Charsets.UTF_8)
    }

    companion object {

        private const val CLIENT_ID_KEY = "client-id"
        private const val INSTALL_ID_KEY = "install-id"
        private var instance: IInstallInfoStorage? = null

        fun getInstance(workingDirectory: File): IInstallInfoStorage
        {
            synchronized(IInstallInfoStorage::class.java)
            {
                if(instance == null) instance = InstallInfoStorageImpl(workingDirectory)
                return instance!!
            }
        }
    }
}