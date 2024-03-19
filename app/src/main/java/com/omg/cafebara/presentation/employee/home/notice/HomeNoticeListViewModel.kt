package com.omg.cafebara.presentation.employee.home.notice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omg.cafebara.domain.model.NoticeData

class HomeNoticeListViewModel : ViewModel() {

    private val _mockNoticeData: MutableLiveData<List<NoticeData>> = MutableLiveData(
        mutableListOf(
            NoticeData(
                "일반",
                1,
                "빨리 개발해",
                "2023.03.18"
            ),
            NoticeData(
                "필독",
                2,
                "빨리 과제해",
                "2023.03.19"
            ),
            NoticeData(
                "일반",
                3,
                "내일 수업 휴강~~",
                "2023.03.19"
            )
        )
    )

    val mockNoticeData: LiveData<List<NoticeData>>
        get() = _mockNoticeData

    private val _selectedNoticeId: MutableLiveData<Int> = MutableLiveData()
    val selectedNoticeId: LiveData<Int>
        get() = _selectedNoticeId

    fun setSelectedNoticeId(id: Int) {
        _selectedNoticeId.value = id
    }
}