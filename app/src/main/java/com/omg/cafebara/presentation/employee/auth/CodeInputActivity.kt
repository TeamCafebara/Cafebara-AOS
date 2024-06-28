package com.omg.cafebara.presentation.employee.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.omg.cafebara.R
import com.omg.cafebara.databinding.ActivityInputCodeBinding
import com.omg.cafebara.util.base.BindingActivity
import com.omg.cafebara.util.context.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CodeInputActivity : BindingActivity<ActivityInputCodeBinding>(R.layout.activity_input_code) {
    private val codeViewModel: CodeInputViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = codeViewModel
        binding.lifecycleOwner = this

        addListeners()
        addObservers()
    }

    private fun initLayout() {
        TODO("Not yet implementd")
    }

    private fun addListeners() {
        binding.root.setOnClickListener {
            hideKeyboard(it)
            binding.ivEraseAll.visibility = View.INVISIBLE
        }
        binding.layoutToolbar.ivBack.setOnClickListener {
            finish()
        }
        binding.btnNext.setOnClickListener {
            moveToWelcome()
        }
    }

    private fun addObservers() {
        codeViewModel.eraseAll.observe(this) {
            if (it) {
                binding.etInputCode.text = null
            }
        }
        codeViewModel.codeValidation.observe(this) {
            if (it) {
                binding.etInputCode.setBackgroundResource(R.drawable.background_code_valid)
            } else {
                binding.etInputCode.setBackgroundResource(R.drawable.background_code_error)
            }
        }
    }

    private fun moveToWelcome() {
        startActivity(Intent(this, WelcomeActivity::class.java))
    }
}
