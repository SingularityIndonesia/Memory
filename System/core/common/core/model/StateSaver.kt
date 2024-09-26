package core.model

data object StateSaver {
    @Deprecated("Do not use this directly!")
    val state: MutableList<Any> = mutableListOf()

    @Suppress("DEPRECATION")
    fun <T : Any> push(state: T) {
        StateSaver.state.add(state)
    }

    @Suppress("DEPRECATION")
    inline fun <reified T : Any> pushOrAmend(state: T) {
        val previousStateExist = StateSaver.state.firstOrNull { it is T } != null

        if (previousStateExist) {
            pop<T>()
        }

        push(state)
    }

    @Suppress("DEPRECATION")
    inline fun <reified T : Any> pop(): T? {
        val state =
            state.firstOrNull {
                it is T
            } as T?

        if (state != null) {
            StateSaver.state.remove(state)
        }

        return state
    }
}
