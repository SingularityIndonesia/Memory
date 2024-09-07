/*
 * Copyright (c) 2024 Singularity Indonesia
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package validation.companion

import validation.InvalidEmpty
import validation.InvalidFormat
import validation.ValidationError

fun <T> ValidationError.tryFoldEmailValidationError(
    onFormatError: (() -> T)? = null,
    onEmptyError: (() -> T)? = null,
    other: (() -> T)? = null,
): T =
    when (this) {
        InvalidFormat -> onFormatError?.invoke() ?: other?.invoke()
        InvalidEmpty -> onEmptyError?.invoke() ?: other?.invoke()
    } ?: run {
        throw IllegalArgumentException("Unhandled ValidationError ${this::class.simpleName}")
    }
