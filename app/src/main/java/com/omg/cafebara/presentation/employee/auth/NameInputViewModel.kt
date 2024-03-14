package com.omg.cafebara.presentation.employee.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NameInputViewModel @Inject constructor() : ViewModel() {
    val name = MutableLiveData("")
    private val _eraseAll: MutableLiveData<Boolean> = MutableLiveData()
    val eraseAll: LiveData<Boolean> = _eraseAll

    fun clickEraseAll() {
        _eraseAll.value = true
    }
}
