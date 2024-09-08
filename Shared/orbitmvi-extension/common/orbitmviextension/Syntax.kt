package orbitmviextension

import kotlinx.coroutines.Job
import kotlinx.coroutines.ensureActive
import org.orbitmvi.orbit.syntax.IntentContext
import org.orbitmvi.orbit.syntax.Syntax

context(Job, Syntax<S, SE>)
suspend fun <S : Any, SE : Any> reduce(
    ensureActive: Boolean,
    reducer: IntentContext<S>.() -> S,
) {
    if (ensureActive) {
        ensureActive()
    }
    reduce(reducer)
}

context(Job, Syntax<S, SE>)
suspend fun <S : Any, SE : Any> postSideEffect(
    ensureActive: Boolean,
    sideEffect: SE,
) {
    if (ensureActive) {
        ensureActive()
    }
    postSideEffect(sideEffect)
}
