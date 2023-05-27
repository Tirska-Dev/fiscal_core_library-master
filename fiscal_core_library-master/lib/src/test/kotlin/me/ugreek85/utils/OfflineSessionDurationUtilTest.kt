package me.ugreek85.utils

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.time.Duration

internal class OfflineSessionDurationUtilTest {

    @Test
    fun getMaxDurationForNextOfflineSession() {

        assertEquals(
            Duration.ofHours(36).toMillis(), OfflineSessionDurationUtil.getMaxDurationForNextOfflineSession(
            Duration.ofHours(0),
            Duration.ofHours(0),
        ))

        assertEquals(
            Duration.ofHours(8).toMillis(), OfflineSessionDurationUtil.getMaxDurationForNextOfflineSession(
            Duration.ofHours(0),
            Duration.ofHours(160),
        ))

        assertEquals(
            Duration.ofHours(6).toMillis(), OfflineSessionDurationUtil.getMaxDurationForNextOfflineSession(
            Duration.ofHours(2),
            Duration.ofHours(160),
        ))

        // test overloaded method

        assertEquals(
            Duration.ofHours(36).toMillis(), OfflineSessionDurationUtil.getMaxDurationForNextOfflineSession(
            Duration.ofHours(0).toMinutes(),
            Duration.ofHours(0).toMinutes(),
        ))

        assertEquals(
            Duration.ofHours(8).toMillis(), OfflineSessionDurationUtil.getMaxDurationForNextOfflineSession(
            Duration.ofHours(0).toMinutes(),
            Duration.ofHours(160).toMinutes(),
        ))

        assertEquals(
            Duration.ofHours(6).toMillis(), OfflineSessionDurationUtil.getMaxDurationForNextOfflineSession(
            Duration.ofHours(2).toMinutes(),
            Duration.ofHours(160).toMinutes(),
        ))
    }
}