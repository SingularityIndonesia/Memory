package core.model

import core.adt.PutStrategy

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
