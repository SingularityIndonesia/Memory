package core.protocol

import core.exception.SystemException
import core.operation.SystemResult
import kotlinx.coroutines.flow.StateFlow

interface AccessControl<E : SystemException> {
    val fallBack: StateFlow<E?>

    fun invoke(request: () -> SystemResult<*>): SystemResult<*>
}
