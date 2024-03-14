package com.omg.cafebara.presentation.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.omg.cafebara.R
import com.omg.cafebara.databinding.ActivitySignBinding
import com.omg.cafebara.presentation.employee.auth.NameInputActivity
import com.omg.cafebara.util.base.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignActivity : BindingActivity<ActivitySignBinding>(R.layout.activity_sign) {
    private val viewModel: SignViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        addListeners()
        addObservers()
    }

    private fun initLayout() {
        TODO("Not yet implemented")
    }

    private fun addListeners() {
        binding.layoutToolbar.ivBack.setOnClickListener {
            finish()
        }
        binding.btnNext.setOnClickListener {
            moveToName()
        }
    }

    private fun addObservers() {

    }

    private fun moveToName() {
        startActivity(Intent(this, NameInputActivity::class.java))
    }
}
