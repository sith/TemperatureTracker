package org.tnt.tempwatchertracker

import org.tnt.tempwatchertracker.InMemoryTemperatureLogger.TemperatureLogger

class InMemoryTemperatureLogger(val loggedTemperatures: MutableList<Double> = ArrayList()) : TemperatureLogger {
    override fun logTemperature(temperature: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
