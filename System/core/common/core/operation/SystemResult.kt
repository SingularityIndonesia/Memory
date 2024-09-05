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

    inline fun <R> map(block: (T) -> R): SystemResult<R> =
        when (this) {
            is Success -> Success(block(this.data))
            is Error -> Error(this.e)
        }
}

inline fun <T> SystemResult<T>.getOrElse(block: (SystemException) -> T): T =
    when (this) {
        is Success<T> -> this.data
        is Error -> block.invoke(this.e)
    }
