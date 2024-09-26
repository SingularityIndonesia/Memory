package development.example.model

import core.adt.SystemResult
import development.example.model.entity.ExampleEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ExampleModel {
    suspend fun getEntities(): SystemResult<List<ExampleEntity>> =
        withContext(Dispatchers.IO) {
            delay(5000)
            val entities = (0..10).map { ExampleEntity(label = "Example Entity $it") }
            SystemResult.Success(entities)
        }
}
