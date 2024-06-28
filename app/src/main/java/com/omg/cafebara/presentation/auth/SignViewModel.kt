package com.omg.cafebara.presentation.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omg.cafebara.presentation.type.EmployType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignViewModel @Inject constructor() : ViewModel() {
    private val _employType: MutableLiveData<EmployType> = MutableLiveData()
    val employType: LiveData<EmployType> = _employType
    val nextStatus: MutableLiveData<Boolean> = MutableLiveData()
//    private val _currentPage: MutableLiveData<Int?> = MutableLiveData()
//    val currentPage = _currentPage

    fun setEmployType(employ: EmployType) {
        _employType.value = employ
        nextStatus.value = true

        //Timber.e("employ type : ${_employType.value}")
    }

//    fun setCurrentPage(position: Int) {
//        _currentPage.value = position
//    }
}