package org.tnt.tempwatchertracker

import kotlinx.coroutines.*
import org.hamcrest.Matchers.`is`
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import java.lang.Thread.sleep
import kotlin.time.ExperimentalTime


@ExperimentalTime
class TemperatureWatcherTest {

    private val readingPadInMillis = 50
    private val temperatureLogger = InMemoryTemperatureLogger()
    private val temperatureSensor = InMemoryTemperatureSensor()
    private val temperatureWatcher: TemperatureWatcher = TemperatureWatcher(temperatureLogger, temperatureSensor)


    @Before
    fun setUp() {
    }

    private fun <T> after(duration: kotlin.time.Duration, value: () -> T): T {
        sleep(duration.toLongMilliseconds())
        return value.invoke()
    }

    @After
    fun tearDown() = runBlocking {
        temperatureWatcher.stop()
    }

    @Test
    fun `stores retrieved temperature`() {
        temperatureWatcher.start()
        sleep(2.temperatureReadings)
        assertThat(temperatureLogger.loggedTemperatures, `is`(listOf(0.0, 1.0)))
    }

    @Test
    fun `no logged readings after stop function`() {
        temperatureWatcher.start()
        sleep(2.temperatureReadings)
        runBlocking { temperatureWatcher.stop() }
        sleep(4.temperatureReadings)
        assertThat(temperatureLogger.loggedTemperatures, `is`(listOf(0.0, 1.0)))
    }

    @Test(expected = IllegalStateException::class)
    fun `cannot run start twice`() {
        temperatureWatcher.start()
        temperatureWatcher.start()
    }

    private val Int.temperatureReadings: Long
        get() {
            return temperatureSensor.readingsDelay.toLongMilliseconds() * this + readingPadInMillis
        }
}