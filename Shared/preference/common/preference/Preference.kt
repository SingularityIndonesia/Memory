package preference

sealed class PutStrategy {
    data object Replace : PutStrategy()

    data object ErrorIfExist : PutStrategy()
}

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

expect class OSDefaultPreference : Preference
