/*
 * Copyright (c) 2024 Singularity Indonesia
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package core.tool

import core.adt.IOSPlatform
import core.adt.Platform
import platform.UIKit.UIDevice

actual fun getPlatform(): Platform = IOSPlatform(UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion)
