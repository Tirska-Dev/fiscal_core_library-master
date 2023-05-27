package me.ugreek85.builder.document.typed.common

interface IOfflineAbilityBuilder<T> {

    fun setOffline(offline: Boolean): T
    fun setPreviousDocumentHash(hash: String?): T
}