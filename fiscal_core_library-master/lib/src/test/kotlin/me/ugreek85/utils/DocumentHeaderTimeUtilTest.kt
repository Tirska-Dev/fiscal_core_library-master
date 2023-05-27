package me.ugreek85.utils

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class DocumentHeaderTimeUtilTest {

    @Test
    fun getDate() {
        assertEquals(DocumentHeaderTimeUtil.getTimeString(Date(1616950274960L)), "195114")
    }

    @Test
    fun getTime() {
        assertEquals(DocumentHeaderTimeUtil.getDateString(Date(1616950274960L)), "28032021")
    }
}