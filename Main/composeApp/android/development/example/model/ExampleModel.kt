package development.example.model

import core.operation.SystemResult
import development.example.model.entity.ExampleEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ExampleModel {
    suspend fun getEntities(): SystemResult<List<ExampleEntity>> =
        withContext(Dispatchers.IO) {
            delay(3000)
            val entities = (0..10).map { ExampleEntity(label = "Example Entity $it") }
            SystemResult.Success(entities)
        }
}
