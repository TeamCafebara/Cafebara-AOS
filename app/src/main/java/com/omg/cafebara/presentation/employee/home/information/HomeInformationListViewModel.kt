package com.omg.cafebara.presentation.employee.home.information

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omg.cafebara.domain.model.NoticeData

class HomeInformationListViewModel : ViewModel() {

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
}