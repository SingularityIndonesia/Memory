/*
 * Copyright (c) 2024 Singularity Indonesia
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package core.ui.designsystem.boson

/**
 * note: please write the system token `as is`, event if it sounds redundant.
 * ex: color/text/text-primary into colorTextTextPrimary.
 */
@Deprecated(
    "Do not call this directly!",
    replaceWith =
        ReplaceWith(
            "SystemToken.current",
            "core.ui.designsystem.SystemToken",
        ),
)
class SystemToken
