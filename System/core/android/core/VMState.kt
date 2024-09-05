package core

import core.exception.UnknownException
import core.operation.SystemResult
import io.ktor.utils.io.errors.IOException

actual fun liftException(e: Throwable?): SystemResult.Error =
    when (e) {
        is IOException -> SystemResult.Error(core.exception.IOException(e.cause))
        else -> SystemResult.Error(UnknownException(e?.cause))
    }
