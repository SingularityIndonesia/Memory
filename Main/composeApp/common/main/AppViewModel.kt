package main

import androidx.lifecycle.ViewModel
import core.model.StateSaver
import core.model.SystemLogger
import core.tool.getPlatform

class AppViewModel : ViewModel() {
    val stateSaver = StateSaver
    val platform = getPlatform()
    val systemLogger = SystemLogger()
}
