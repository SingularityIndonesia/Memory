/*
 * Copyright (c) 2024 Singularity Indonesia
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package core.tool

import android.os.Build
import core.adt.AndroidPlatform
import core.adt.Platform

actual fun getPlatform(): Platform = AndroidPlatform("Android ${Build.VERSION.SDK_INT}")
