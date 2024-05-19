package com.omg.cafebara.presentation.employee.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    fun uploadDummy() {
        viewModelScope.launch {
            // TODO
        }
    }
}
