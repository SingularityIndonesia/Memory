package core.pattern

import core.adt.SystemResult
import core.tool.Mockable

@Mockable
interface WebClient {
    val host: String

    val basePath: String

    /**
     * @param params map of key vs value
     * @param body json string body request
     */
    suspend fun post(
        endpoint: String? = null,
        headers: Map<String, String>? = null,
        params: Map<String, String>? = null,
        body: String?,
    ): SystemResult<suspend () -> ByteArray>

    /**
     * @param params map of key vs value
     */
    suspend fun get(
        endpoint: String? = null,
        headers: Map<String, String>? = null,
        params: Map<String, String>? = null,
    ): SystemResult<suspend () -> ByteArray>

    /**
     * @param params map of key vs value
     * @param body json string body request
     */
    suspend fun put(
        endpoint: String? = null,
        headers: Map<String, String>? = null,
        params: Map<String, String>? = null,
        body: String?,
    ): SystemResult<suspend () -> ByteArray>
}
