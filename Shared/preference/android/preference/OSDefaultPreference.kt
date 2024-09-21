package preference

import android.content.SharedPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeoutException
import kotlin.coroutines.resume

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class OSDefaultPreference(
    private val androidPreference: SharedPreferences,
) : Preference {
    companion object {
        const val CONTENT_NULL = "CONTENT NULL"
        const val OPERATION_TIMEOUT_DURATION = 1000L
    }

    override suspend fun put(
        id: String,
        content: String,
        strategy: PutStrategy,
    ): Result<Pair<String, String>> =
        suspendCancellableCoroutine { continuation ->
            val coroutine = CoroutineScope(Dispatchers.IO + SupervisorJob())

            continuation.invokeOnCancellation {
                coroutine.cancel()
            }

            // error strategy
            when (strategy) {
                PutStrategy.ErrorIfExist -> {
                    if (androidPreference.contains(id)) {
                        continuation.resume(Result.failure(IllegalArgumentException()))
                    }
                }

                else -> {
                    /**do nothing**/
                }
            }

            coroutine.launch {
                androidPreference
                    .edit()
                    .remove(id)
                    .putString(id, content)
                    .apply()

                var totalWaitingDuration = 0L
                while (!androidPreference.getString(id, "").equals(content)) {
                    if (totalWaitingDuration >= OPERATION_TIMEOUT_DURATION) {
                        coroutine.cancel()
                        continuation.resume(Result.failure(TimeoutException()))
                        break
                    }

                    delay(100L)
                    totalWaitingDuration += 100
                }

                ensureActive()
                continuation.resume(Result.success(id to content))
            }
        }

    override suspend fun get(id: String): Result<String> =
        withContext(Dispatchers.IO) {
            runCatching {
                val result = androidPreference.getString(id, CONTENT_NULL) ?: CONTENT_NULL

                if (result == CONTENT_NULL) {
                    throw NullPointerException()
                } else {
                    result
                }
            }
        }

    override suspend fun delete(id: String): Result<String> =
        withContext(Dispatchers.IO) {
            runCatching {
                val target = androidPreference.getString(id, CONTENT_NULL) ?: CONTENT_NULL

                if (target == CONTENT_NULL) {
                    return@runCatching CONTENT_NULL
                }

                androidPreference
                    .edit()
                    .remove(id)
                    .apply()

                var totalWaitingDuration = 0L
                while (androidPreference.contains(id)) {
                    if (totalWaitingDuration >= OPERATION_TIMEOUT_DURATION) {
                        throw TimeoutException()
                    }
                    delay(100L)
                    totalWaitingDuration += 100L
                }

                target
            }
        }

    override suspend fun clear(): Result<Map<String, *>> =
        withContext(Dispatchers.IO) {
            runCatching {
                val allContent = androidPreference.all

                if (allContent.isEmpty()) {
                    return@runCatching allContent
                }

                androidPreference
                    .edit()
                    .clear()
                    .apply()

                var totalWaitingDuration = 0L
                while (androidPreference.all.isNotEmpty()) {
                    if (totalWaitingDuration >= OPERATION_TIMEOUT_DURATION) {
                        throw TimeoutException()
                    }
                    delay(100L)
                    totalWaitingDuration += 100L
                }

                allContent
            }
        }
}
