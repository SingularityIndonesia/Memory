package core

import core.exception.UnknownException
import core.operation.SystemResult

actual fun liftException(e: Throwable?): SystemResult.Error =
    when (e) {
        is io.ktor.utils.io.errors.IOException -> SystemResult.Error(core.exception.IOException(e.cause))
        else -> SystemResult.Error(UnknownException(e?.cause))
    }
