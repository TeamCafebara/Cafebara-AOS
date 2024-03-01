package com.omg.cafebara.data.service

import com.omg.cafebara.data.model.request.RequestDummy
import com.omg.cafebara.data.model.response.ResponseDummy
import retrofit2.http.Body
import retrofit2.http.POST

interface DummyService {
    @POST("api/dummy")
    suspend fun uploadDummy(@Body request: RequestDummy): ResponseDummy
}
