package com.omg.cafebara.presentation.employee.auth

import android.os.Bundle
import androidx.activity.viewModels
import com.omg.cafebara.R
import com.omg.cafebara.databinding.ActivityWelcomeBinding
import com.omg.cafebara.util.base.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeActivity : BindingActivity<ActivityWelcomeBinding>(R.layout.activity_welcome) {
    private val welcomeViewModel: WelcomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = welcomeViewModel
        //binding.lifecycleOwner = this
        // binding에서 LiveData를 사용할 경우 해당 코드 필요
        addListeners()
    }

    private fun initLayout() {
        TODO("Not yet implemented")
    }

    private fun addListeners() {
        binding.btnStart.setOnClickListener {
            showAlertDialog()
        }
        binding.layoutToolbar.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun addObservers() {
        TODO("Not yet implemented")
    }

    private fun showAlertDialog() {
        AlertDialog().show(supportFragmentManager, DIALOG)
    }

    companion object {
        const val DIALOG = "dialog"
    }
}
