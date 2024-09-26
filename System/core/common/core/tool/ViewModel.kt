package core.tool

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

inline fun <T> ViewModel.launch(
    context: CoroutineContext = Dispatchers.IO,
    crossinline block: suspend Job.() -> T,
): Job {
    val supervisor = SupervisorJob()

    return viewModelScope.launch(context + supervisor) {
        block.invoke(supervisor)
    }
}
