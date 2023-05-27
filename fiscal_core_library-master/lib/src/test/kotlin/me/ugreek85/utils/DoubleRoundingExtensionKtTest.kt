package me.ugreek85.utils

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DoubleRoundingExtensionKtTest {

    @Test
    fun roundString() {

        assertEquals(1.0.roundString(2), "1.00")
        assertEquals(1.11.roundString(2), "1.11")
        assertEquals(1.111.roundString(2), "1.11")
        assertEquals(1.114.roundString(2), "1.11")
        assertEquals(1.115.roundString(2), "1.12")

    }

    @Test
    fun roundDouble() {

        assertEquals(1.114.roundDouble(2), 1.11)
        assertEquals(1.115.roundDouble(2), 1.12)

    }
}