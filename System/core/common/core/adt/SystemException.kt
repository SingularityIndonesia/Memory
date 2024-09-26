package core.adt

sealed class SystemException(
    throwable: Throwable?,
) : Exception(throwable) {
    constructor(message: String) : this(Throwable(message))
}

// Protocol Exceptions species ---------------------------------------------------------------------
// -------------------------------------------------------------------------------------------------
sealed class ProtocolException(
    throwable: Throwable?,
) : SystemException(throwable) {
    constructor(message: String) : this(Throwable(message))
}

data class AuthenticationException(
    val throwable: Throwable?,
) : ProtocolException(throwable) {
    constructor(message: String) : this(Throwable(message))
}

data class IdentificationException(
    val throwable: Throwable?,
) : ProtocolException(throwable) {
    constructor(message: String) : this(Throwable(message))
}

data class OSPermissionException(
    val throwable: Throwable?,
) : ProtocolException(throwable) {
    constructor(message: String) : this(Throwable(message))
}

data class ABACException(
    val throwable: Throwable?,
) : ProtocolException(throwable) {
    constructor(message: String) : this(Throwable(message))
}

data class RBACException(
    val throwable: Throwable?,
) : ProtocolException(throwable) {
    constructor(message: String) : this(Throwable(message))
}

data class UnknownProtocolException(
    val throwable: Throwable?,
) : ProtocolException(throwable) {
    constructor(message: String) : this(Throwable(message))
}

// Common Exceptions species ---------------------------------------------------------------------
// -------------------------------------------------------------------------------------------------
data class NullPointerException(
    val throwable: Throwable?,
) : SystemException(throwable) {
    constructor(message: String) : this(Throwable(message))
}

data class IOException(
    val throwable: Throwable?,
) : SystemException(throwable) {
    constructor(message: String) : this(Throwable(message))
}

data class IllegalArgumentException(
    val throwable: Throwable?,
) : SystemException(throwable) {
    constructor(message: String) : this(Throwable(message))
}

data class InterruptedException(
    val throwable: Throwable?,
) : SystemException(throwable) {
    constructor(message: String) : this(Throwable(message))
}

data class CancellationException(
    val throwable: Throwable?,
) : SystemException(throwable) {
    constructor(message: String) : this(Throwable(message))
}

data class UnknownException(
    val throwable: Throwable?,
) : SystemException(throwable) {
    constructor(message: String) : this(Throwable(message))
}
