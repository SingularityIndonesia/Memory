package core.pattern

import core.adt.SystemException
import core.adt.SystemResult
import kotlinx.coroutines.flow.StateFlow

interface AccessControl<E : SystemException> {
    val fallBack: StateFlow<E?>

    suspend fun <T> invoke(request: () -> SystemResult<T>): SystemResult<T>
}
