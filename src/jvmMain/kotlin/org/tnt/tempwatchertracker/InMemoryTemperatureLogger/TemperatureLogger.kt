package org.tnt.tempwatchertracker.InMemoryTemperatureLogger


interface TemperatureLogger {
    fun logTemperature(temperature: Double)
}