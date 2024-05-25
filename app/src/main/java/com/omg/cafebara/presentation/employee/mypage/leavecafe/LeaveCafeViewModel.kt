package com.omg.cafebara.presentation.employee.mypage.leavecafe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omg.cafebara.domain.model.CafeList

class LeaveCafeViewModel : ViewModel() {

    private val _mockCafeList: MutableLiveData<ArrayList<CafeList>> = MutableLiveData(
        arrayListOf(
            CafeList(
                1,
                "티니핑카페",
                "2024.02.12"
            ),
            CafeList(
                2,
                "이게뭐지",
                "2024.02.12"
            ),
            CafeList(
                3,
                "김이박최명김이박최명김이박최명카페에",
                "2024.02.12"
            )
        )
    )

    val mockCafeList: LiveData<ArrayList<CafeList>>
        get() = _mockCafeList

    private val _leaveCafeBtnEnabled = MutableLiveData<Boolean>()
    val leaveCafeBtnEnabled: LiveData<Boolean>
        get() = _leaveCafeBtnEnabled

    fun setLeaveCafeBtnEnabled(boolean: Boolean) {
        _leaveCafeBtnEnabled.value = boolean
    }
}