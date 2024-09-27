package core.model

import core.adt.SystemResult
import core.pattern.WebClient

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class DefaultWebClient : WebClient {
    override val host: String
    override val basePath: String

    override suspend fun get(
        endpoint: String?,
        headers: Map<String, String>?,
        params: Map<String, String>?,
    ): SystemResult<suspend () -> ByteArray>

    override suspend fun post(
        endpoint: String?,
        headers: Map<String, String>?,
        params: Map<String, String>?,
        body: String?,
    ): SystemResult<suspend () -> ByteArray>

    override suspend fun put(
        endpoint: String?,
        headers: Map<String, String>?,
        params: Map<String, String>?,
        body: String?,
    ): SystemResult<suspend () -> ByteArray>
}
