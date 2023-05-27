package me.ugreek85.storage.document_info

import com.google.gson.annotations.SerializedName

enum class DocumentInfoState(private val state: Int) {

    CREATED(1),

    SENDING(2),

    ACCEPTED(3),

    SAVING(4),

    SAVED(5);

    fun getValue(): Int
    {
        return state
    }
}