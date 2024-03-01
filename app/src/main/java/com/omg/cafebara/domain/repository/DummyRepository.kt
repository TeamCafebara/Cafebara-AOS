package com.omg.cafebara.domain.repository

import com.omg.cafebara.domain.model.DummyData

interface DummyRepository {
    suspend fun uploadDummy(name: String, email: String): Result<DummyData>
}
