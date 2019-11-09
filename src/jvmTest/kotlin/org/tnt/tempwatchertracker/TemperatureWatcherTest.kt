package org.tnt.tempwatchertracker

import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TemperatureWatcherTest {

    val temperatureLogger = InMemoryTemperatureLogger()
    @Mock
    lateinit var temperatureSensor: TemperatureSensor
    val temperatureWatcher = TemperatureWatcher(temperatureLogger, temperatureSensor)

    @Before
    fun setUp() {
        `when`(temperatureSensor.read()).thenReturn(1.0).thenReturn(2.0).thenReturn(null)
    }

    @After
    fun tearDown() {
        temperatureWatcher.stop()
    }

    @Test
    fun `stores retrieved temperature`() {


        temperatureWatcher.start()
        temperatureWatcher.stop()

//        assertThat(temperatureLogger.loggedTemperatures, contains(listOf(1.0, 2.0)))


    }
}