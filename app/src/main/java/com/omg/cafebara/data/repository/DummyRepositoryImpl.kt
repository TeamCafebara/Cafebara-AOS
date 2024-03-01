package com.omg.cafebara.data.repository

import com.omg.cafebara.data.datasource.remote.DummyDataSource
import com.omg.cafebara.data.model.request.RequestDummy
import com.omg.cafebara.domain.model.DummyData
import com.omg.cafebara.domain.repository.DummyRepository
import javax.inject.Inject

class DummyRepositoryImpl @Inject constructor(
    private val dummyDataSource: DummyDataSource,
) : DummyRepository {
    override suspend fun uploadDummy(name: String, email: String): Result<DummyData> =
        runCatching {
            dummyDataSource.uploadDummy(RequestDummy(name, email)).data.toDummyData()
        }
}
