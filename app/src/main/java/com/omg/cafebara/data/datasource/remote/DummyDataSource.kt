package com.omg.cafebara.data.datasource.remote

import com.omg.cafebara.data.model.request.RequestDummy
import com.omg.cafebara.data.model.response.ResponseDummy
import com.omg.cafebara.data.service.DummyService
import javax.inject.Inject

class DummyDataSource @Inject constructor(
    private val dummyService: DummyService,
) {
    suspend fun uploadDummy(requestDummy: RequestDummy): ResponseDummy =
        dummyService.uploadDummy(requestDummy)
}
