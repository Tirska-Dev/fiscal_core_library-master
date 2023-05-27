package me.ugreek85.utils

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Crc32Test {

    @Test
    fun get() {

        val crc32 = Crc32.get("179625192271939,20082020,142338,10,4000002411,10,cdd68bb111f8993f3603f0179341571b35b73a07d5acee9b28fbfb714698e1b3".toByteArray())
        val checkValue = 3185294758
        assertEquals(crc32.toUInt(), checkValue.toUInt())

    }
}