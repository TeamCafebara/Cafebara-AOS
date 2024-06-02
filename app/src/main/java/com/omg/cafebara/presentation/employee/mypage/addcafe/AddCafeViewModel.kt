package com.omg.cafebara.presentation.employee.mypage.addcafe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddCafeViewModel : ViewModel() {

    val inviteCode: MutableLiveData<String> = MutableLiveData("")

    private val _codeBtnEnabled = MutableLiveData<Boolean>()
    val codeBtnEnabled: LiveData<Boolean>
        get() = _codeBtnEnabled

    fun checkIsCodeBtnEnabled() {
        _codeBtnEnabled.value = !inviteCode.value.isNullOrBlank()
    }

    fun checkIsCodeValid() {
        // TODO 인증코드 유효한지 확인
    }
}
