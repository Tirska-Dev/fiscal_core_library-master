package me.ugreek85.storage.common

import java.io.File

object DirectoryUtil {

    fun deleteRecursively(file: File)
    {
        if(!file.isDirectory) return
        val files = file.listFiles() ?: return
        files.forEach {
            if(it.isDirectory) deleteRecursively(it)
            it.delete()
        }
    }
}