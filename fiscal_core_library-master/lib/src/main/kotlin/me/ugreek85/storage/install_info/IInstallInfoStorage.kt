package me.ugreek85.storage.install_info

interface IInstallInfoStorage {

    // Client ID
    fun getClientId(): String?
    fun setClientId(clientId: String)
    fun existClientId(): Boolean

    // Install ID
    fun getInstallId(): String?
    fun setInstallId(installId: String)
    fun existInstallId(): Boolean
}