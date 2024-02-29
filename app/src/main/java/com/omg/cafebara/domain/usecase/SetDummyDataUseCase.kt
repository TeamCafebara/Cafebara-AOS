package com.omg.cafebara.domain.usecase

import com.omg.cafebara.domain.repository.DummyDataRepository

class SetDummyDataUseCase(
    private val dummyDataRepository: DummyDataRepository
) {
    operator fun invoke(dummy: Int) = dummyDataRepository.setDummyData(dummy = dummy)
}
