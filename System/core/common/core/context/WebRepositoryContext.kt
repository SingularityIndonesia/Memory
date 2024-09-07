/*
 * Copyright (c) 2024 Singularity Indonesia
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package core.context

import core.test.Mockable

@Mockable
interface WebRepositoryContext {
    val webClient: WebClient
}
