package core.model

import core.adt.PutStrategy
import core.pattern.Preference

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class OSPreference : Preference {
    override suspend fun put(
        id: String,
        content: String,
        strategy: PutStrategy,
    ): Result<Pair<String, String>>

    override suspend fun get(id: String): Result<String>

    override suspend fun delete(id: String): Result<String>

    override suspend fun clear(): Result<Map<String, *>>
}
