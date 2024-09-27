package core.model.impl

import android.content.Context
import core.adt.PutStrategy
import core.model.Preference
import preference.OSPreference

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class OSPreference(
    context: Context,
) : Preference {
    private val osPreference =
        OSPreference(context.getSharedPreferences("default", Context.MODE_PRIVATE))

    private fun toPreferenceStrategy(strategy: PutStrategy): preference.PutStrategy =
        when (strategy) {
            PutStrategy.ErrorIfExist -> preference.PutStrategy.ErrorIfExist
            PutStrategy.Replace -> preference.PutStrategy.Replace
        }

    actual override suspend fun put(
        id: String,
        content: String,
        strategy: PutStrategy,
    ): Result<Pair<String, String>> =
        osPreference.put(
            id,
            content,
            strategy.let(::toPreferenceStrategy),
        )

    actual override suspend fun get(id: String): Result<String> = osPreference.get(id)

    actual override suspend fun delete(id: String): Result<String> = osPreference.delete(id)

    actual override suspend fun clear(): Result<Map<String, *>> = osPreference.clear()
}
