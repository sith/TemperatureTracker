package org.tnt.tempwatchertracker

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.nio.file.Files
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.seconds

class TempWatcherTrackerAppTest {
    val appRoot =
        Files.createTempDirectory(TempWatcherTrackerAppTest::class.java.canonicalName + System.currentTimeMillis())
            .toFile()
    val statistics = Statistics

    val tempWatcherTrackerApp = TempWatcherTrackerApp(TempWatcherConfiguration(appRoot = appRoot))

    @Before
    fun setUp() {
        tempWatcherTrackerApp.start()
    }

    @After
    fun tearDown() {
        tempWatcherTrackerApp.stop()
    }

    @ExperimentalTime
    @Test
    fun `records incoming temperatures`() {


    }

    @ExperimentalTime
    private fun collectTemperaturesFor(seconds: Duration) {
        Thread.sleep(seconds.toLongMilliseconds())
    }
}