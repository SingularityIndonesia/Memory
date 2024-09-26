package core.adt

sealed class PutStrategy {
    data object Replace : PutStrategy()

    data object ErrorIfExist : PutStrategy()
}
