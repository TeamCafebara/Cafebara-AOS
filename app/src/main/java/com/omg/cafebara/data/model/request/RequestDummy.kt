package com.omg.cafebara.data.model.request

import kotlinx.serialization.Serializable

@Serializable
data class RequestDummy(
    val name: String,
    val email: String,
)
