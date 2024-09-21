package core.exception

sealed class SystemException(
    throwable: Throwable?,
) : Exception(throwable)

// Protocol Exceptions species ---------------------------------------------------------------------
// -------------------------------------------------------------------------------------------------
sealed class ProtocolException(
    throwable: Throwable?,
) : SystemException(throwable)

data class AuthenticationException(
    val throwable: Throwable?,
) : ProtocolException(throwable)

data class IdentificationException(
    val throwable: Throwable?,
) : ProtocolException(throwable)

data class OSPermissionException(
    val throwable: Throwable?,
) : ProtocolException(throwable)

data class ABACException(
    val throwable: Throwable?,
) : ProtocolException(throwable)

data class RBACException(
    val throwable: Throwable?,
) : ProtocolException(throwable)

data class UnknownProtocolException(
    val throwable: Throwable?,
) : ProtocolException(throwable)

// Common Exceptions species ---------------------------------------------------------------------
// -------------------------------------------------------------------------------------------------
data class NullPointerException(
    val throwable: Throwable?,
) : SystemException(throwable)

data class IOException(
    val throwable: Throwable?,
) : SystemException(throwable)

data class IllegalArgumentException(
    val throwable: Throwable?,
) : SystemException(throwable)

data class InterruptedException(
    val throwable: Throwable?,
) : SystemException(throwable)

data class CancellationException(
    val throwable: Throwable?,
) : SystemException(throwable)

data class UnknownException(
    val throwable: Throwable?,
) : SystemException(throwable)
