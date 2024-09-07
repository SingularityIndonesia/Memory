package core.protocol

import core.exception.SystemException
import core.operation.SystemResult
import kotlinx.coroutines.flow.StateFlow

interface AccessControl<E : SystemException> {
    val fallBack: StateFlow<E?>

    suspend fun <T> invoke(request: () -> SystemResult<T>): SystemResult<T>
}
