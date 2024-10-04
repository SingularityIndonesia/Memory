package core.model

import core.adt.AuthenticationException
import core.adt.SystemException
import core.adt.SystemResult
import kotlinx.coroutines.flow.StateFlow

interface AccessControl<E : SystemException> {
    suspend fun <T> invoke(request: () -> SystemResult<T>): SystemResult<T>
}
