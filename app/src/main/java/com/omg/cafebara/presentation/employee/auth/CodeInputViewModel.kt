package com.omg.cafebara.presentation.employee.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CodeInputViewModel @Inject constructor() : ViewModel() {
    val inputCode = MutableLiveData("")
    private val _eraseAll : MutableLiveData<Boolean> = MutableLiveData()
    val eraseAll : LiveData<Boolean> = _eraseAll
    private val _nextStatus :MutableLiveData<Boolean> = MutableLiveData()
    val nextStatus : LiveData<Boolean> = _nextStatus
    private val _codeValidation : MutableLiveData<Boolean> = MutableLiveData()
    val codeValidation: LiveData<Boolean> = _codeValidation
    private val _codeValidationStatus : MutableLiveData<Boolean> = MutableLiveData()
    val codeValidationStatus :LiveData<Boolean> = _codeValidationStatus

    fun clickEraseAll(){
        _eraseAll.value = true
    }

    fun defineCode(){
        //코드 인증 과정 필요
        _nextStatus.value = true
        _codeValidation.value = false
        _codeValidationStatus.value = true
    }
}