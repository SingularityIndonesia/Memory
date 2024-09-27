package core.model.dummy

import core.model.SystemLogger

object DummySystemLogger : SystemLogger {
    override fun log(message: String) {}
}
