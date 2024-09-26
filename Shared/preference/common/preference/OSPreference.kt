package preference

sealed class PutStrategy {
    data object Replace : PutStrategy()

    data object ErrorIfExist : PutStrategy()
}

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class OSPreference {
    suspend fun put(
        id: String,
        content: String,
        strategy: PutStrategy,
    ): Result<Pair<String, String>>

    suspend fun get(id: String): Result<String>

    suspend fun delete(id: String): Result<String>

    suspend fun clear(): Result<Map<String, *>>
}
