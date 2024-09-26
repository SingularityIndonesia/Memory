package core.adt

actual fun liftException(e: Throwable?): SystemResult.Error =
    when (e) {
        is io.ktor.utils.io.errors.IOException -> SystemResult.Error(IOException(e.cause))
        else -> SystemResult.Error(UnknownException(e?.cause))
    }
