package org.tnt.tempwatchertracker


interface TemperatureSensor {
    fun read(): Double?
}