package org.tnt.tempwatchertracker

import kotlinx.coroutines.*


class TempWatcherTrackerApp(tempWatcherConfiguration: TempWatcherConfiguration) {
    val stats = Statistics
    var mainCoroutine: Job? = null

    fun start() {
        val mainCoroutine = GlobalScope.launch {
            while (isActive) {

            }
        }
    }

    fun stop() = runBlocking {
        mainCoroutine?.cancelAndJoin()
    }
}