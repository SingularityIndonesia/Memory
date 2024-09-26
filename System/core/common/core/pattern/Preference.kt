package core.pattern

import core.adt.CancellationException
import core.adt.PutStrategy

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
interface Preference {
    suspend fun put(
        id: String,
        content: String,
        strategy: PutStrategy,
    ): Result<Pair<String, String>>

    suspend fun get(id: String): Result<String>

    suspend fun delete(id: String): Result<String>

    suspend fun clear(): Result<Map<String, *>>
}

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
