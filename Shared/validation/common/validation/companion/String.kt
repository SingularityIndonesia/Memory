/*
 * Copyright (c) 2024 Singularity Indonesia
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package validation.companion

import validation.ValidationError
import validation.Validator

fun String.validateWith(validator: Validator): ValidationError? =
    validator
        .asIterable()
        .firstOrNull {
            this.matches(it.key.toRegex())
        }?.value
