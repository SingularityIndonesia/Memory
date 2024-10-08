package core.adt

actual fun liftException(e: Throwable?): SystemResult.Error =
    when (e) {
        is okio.IOException -> SystemResult.Error(IOException(e))
        is java.io.IOException -> SystemResult.Error(IOException(e))
        is io.ktor.utils.io.errors.IOException -> SystemResult.Error(IOException(e.cause))
        is IllegalArgumentException -> SystemResult.Error(IllegalArgumentException(e))
        is NullPointerException -> SystemResult.Error(NullPointerException(e))
        is InterruptedException -> SystemResult.Error(InterruptedException(e))
        is kotlinx.coroutines.CancellationException -> SystemResult.Error(CancellationException(e))
        is io.ktor.utils.io.CancellationException -> SystemResult.Error(CancellationException(e))
        is kotlin.coroutines.cancellation.CancellationException ->
            SystemResult.Error(
                CancellationException(e),
            )
        else -> SystemResult.Error(UnknownException(e?.cause))
    }
