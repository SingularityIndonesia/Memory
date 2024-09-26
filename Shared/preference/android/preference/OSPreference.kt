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
actual class OSPreference(
    private val androidPreference: SharedPreferences,
) {
    companion object {
        const val CONTENT_NULL = "CONTENT NULL"
        const val OPERATION_TIMEOUT_DURATION = 1000L
    }

    actual suspend fun put(
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

                val waitingDelay = 100L
                var totalWaitingDuration = 0L
                while (!androidPreference.getString(id, "").equals(content)) {
                    if (totalWaitingDuration >= OPERATION_TIMEOUT_DURATION) {
                        coroutine.cancel()
                        continuation.resume(Result.failure(TimeoutException()))
                        break
                    }

                    delay(waitingDelay)
                    totalWaitingDuration += waitingDelay
                }

                ensureActive()
                continuation.resume(Result.success(id to content))
            }
        }

    actual suspend fun get(id: String): Result<String> =
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

    actual suspend fun delete(id: String): Result<String> =
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

                val waitingDelay = 100L
                var totalWaitingDuration = 0L
                while (androidPreference.contains(id)) {
                    if (totalWaitingDuration >= OPERATION_TIMEOUT_DURATION) {
                        throw TimeoutException()
                    }
                    delay(waitingDelay)
                    totalWaitingDuration += waitingDelay
                }

                target
            }
        }

    actual suspend fun clear(): Result<Map<String, *>> =
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

                val waitingDelay = 100L
                var totalWaitingDuration = 0L
                while (androidPreference.all.isNotEmpty()) {
                    if (totalWaitingDuration >= OPERATION_TIMEOUT_DURATION) {
                        throw TimeoutException()
                    }
                    delay(waitingDelay)
                    totalWaitingDuration += waitingDelay
                }

                allContent
            }
        }
}
