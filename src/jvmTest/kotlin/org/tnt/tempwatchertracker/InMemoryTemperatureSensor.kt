package org.tnt.tempwatchertracker

import kotlinx.coroutines.delay
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.milliseconds

@ExperimentalTime
class InMemoryTemperatureSensor(var temperature: Double = 0.0, val readingsDelay: Duration = 100.milliseconds) :
    TemperatureSensor {
    override suspend fun read(): Double? {
        delay(readingsDelay.toLongMilliseconds())
        return temperature++
    }
}
