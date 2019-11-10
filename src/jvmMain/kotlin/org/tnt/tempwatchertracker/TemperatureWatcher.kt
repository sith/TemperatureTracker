package org.tnt.tempwatchertracker

import kotlinx.coroutines.*
import org.tnt.tempwatchertracker.InMemoryTemperatureLogger.TemperatureLogger


class TemperatureWatcher(
    val temperatureLogger: TemperatureLogger,
    val temperatureSensor: TemperatureSensor
) {
    var job: Job? = null

    suspend fun stop() {
        job?.cancelAndJoin()
    }

    fun start() {
        if (job != null) {
            throw IllegalStateException("TemperatureWatcher has already been started")
        }
        job = GlobalScope.launch {
            while (isActive) {
                temperatureSensor.read()?.let { temperatureLogger.logTemperature(it) }
            }
        }
    }
}