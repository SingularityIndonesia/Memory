package core.operation

import core.exception.SystemException
import core.operation.SystemResult.Error
import core.operation.SystemResult.Success

sealed class SystemResult<out T> {
    data class Success<T>(
        val data: T,
    ) : SystemResult<T>()

    data class Error(
        val e: SystemException,
    ) : SystemResult<Nothing>()
}

inline fun <T, R> SystemResult<T>.map(block: (T) -> R): SystemResult<R> =
    when (this) {
        is Success -> Success(block.invoke(this.data))
        is Error -> this
    }

inline fun <T> SystemResult<T>.getOrElse(block: (SystemException) -> T): T =
    when (this) {
        is Success<T> -> this.data
        is Error -> block.invoke(this.e)
    }

inline fun <T, R> SystemResult<T>.flatMap(block: (T) -> SystemResult<R>): SystemResult<R> =
    when (this) {
        is Success -> block.invoke(this.data)
        is Error -> this
    }

inline fun <T> SystemResult<T>.onSuccess(block: (T) -> Unit): SystemResult<T> {
    if (this is Success) {
        block.invoke(this.data)
    }
    return this
}

inline fun <T> SystemResult<T>.onError(block: (SystemException) -> Unit): SystemResult<T> {
    if (this is Error) {
        block.invoke(this.e)
    }
    return this
}
