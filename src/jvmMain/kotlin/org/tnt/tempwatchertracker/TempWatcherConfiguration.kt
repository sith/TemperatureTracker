package org.tnt.tempwatchertracker

import java.io.File

data class TempWatcherConfiguration(val appRoot: File = File("~/.tempwatcher")) {
    init {
        if (!appRoot.exists()) {
            appRoot.mkdir()
        }
    }
}