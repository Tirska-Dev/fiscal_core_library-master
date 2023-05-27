package me.ugreek85.utils

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class KeyGeneratorTest {

    @Test
    fun generateKey() {

        val uuid = UUID.fromString("55bbb9be-a3ea-4de3-8f23-ac7c844025ce")
        val bytes = KeyGenerator.generateKey(uuid, 256 / 8)
        assertEquals("HuMYssa0pjcNeaZWVfsjq8dzMpH+3iPnm5O9KCZGyLs=", Base64.getEncoder().encodeToString(bytes))

    }
}