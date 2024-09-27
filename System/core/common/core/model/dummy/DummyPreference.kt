package core.model.dummy

import core.adt.CancellationException
import core.adt.PutStrategy
import core.model.Preference

object DummyPreference : Preference {
    override suspend fun put(
        id: String,
        content: String,
        strategy: PutStrategy,
    ): Result<Pair<String, String>> = Result.failure(CancellationException("dummy"))

    override suspend fun get(id: String): Result<String> = Result.failure(CancellationException("dummy"))

    override suspend fun delete(id: String): Result<String> = Result.failure(CancellationException("dummy"))

    override suspend fun clear(): Result<Map<String, *>> = Result.failure(CancellationException("dummy"))
}
