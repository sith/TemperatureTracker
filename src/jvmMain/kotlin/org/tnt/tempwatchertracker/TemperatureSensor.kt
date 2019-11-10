package org.tnt.tempwatchertracker


interface TemperatureSensor {
    suspend fun read(): Double?
}