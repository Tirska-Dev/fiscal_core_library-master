package me.ugreek85.storage.common

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class DirectoryUtilTest {

    @Test
    fun deleteRecursively() {

        val dir = File("tmp/data/documents/info")
        DirectoryUtil.deleteRecursively(dir)

        assertTrue(dir.listFiles() == null || dir.listFiles().isEmpty())

    }
}