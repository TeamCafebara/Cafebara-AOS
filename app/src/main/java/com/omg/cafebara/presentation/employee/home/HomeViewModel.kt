package com.omg.cafebara.presentation.employee.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omg.cafebara.domain.model.HomeNotice

class HomeViewModel : ViewModel() {

    private val _mockHomeNotice: MutableLiveData<List<HomeNotice>> = MutableLiveData(
        mutableListOf(
            HomeNotice(
                "https://github.com/TeamCafebara/Cafebara-AOS/assets/145532333/1b978f8f-d926-45d8-adfe-84e2624197d2",
                "필독",
                1,
                "생크림 안 만들고 가면 해고입니다."
            ),
            HomeNotice(
                "https://github.com/TeamCafebara/Cafebara-AOS/assets/145532333/d6cee827-269d-4ff3-a4e9-3d0a32ddd4f9",
                "필독",
                2,
                "내일은 휴무입니다. 나오지 마세요."
            )
        )
    )

    val mockHomeNotice: LiveData<List<HomeNotice>>
        get() = _mockHomeNotice

    private val _selectedNoticeId: MutableLiveData<Int> = MutableLiveData(0)
    val selectedNoticeId: LiveData<Int>
        get() = _selectedNoticeId

    fun setSelectedNoticeId(id: Int) {
        _selectedNoticeId.value = id
    }
}
