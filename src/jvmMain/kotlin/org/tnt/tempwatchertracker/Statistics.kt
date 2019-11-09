package org.tnt.tempwatchertracker

object Statistics {
    var numberOfLoadedTemperatures: Long = 0
        private set

    fun temperatureLoaded() {
        numberOfLoadedTemperatures++
    }
}