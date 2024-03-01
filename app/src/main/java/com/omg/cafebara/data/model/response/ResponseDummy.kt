package com.omg.cafebara.data.model.response

import com.omg.cafebara.domain.model.DummyData
import kotlinx.serialization.Serializable

@Serializable
data class ResponseDummy(
    val status: Int,
    val message: String,
    val data: ResponseData,
) {
    @Serializable
    data class ResponseData(
        val id: Int,
        val name: String,
        val email: String,
    ) {
        fun toDummyData() = DummyData(
            id = id.toString(),
            email = email,
            name = name
        )
    }
}
