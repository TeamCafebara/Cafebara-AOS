package com.omg.cafebara.presentation.employee.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.omg.cafebara.R
import com.omg.cafebara.databinding.ActivityInputNameBinding
import com.omg.cafebara.presentation.type.EmployType
import com.omg.cafebara.util.base.BindingActivity
import com.omg.cafebara.util.context.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NameInputActivity : BindingActivity<ActivityInputNameBinding>(R.layout.activity_input_name) {
    private val nameViewModel: NameInputViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = nameViewModel
        binding.lifecycleOwner = this

        initLayout()
        addListeners()
        addObservers()
    }

    private fun initLayout() {
        binding.employType = EmployType.EMPLOYEE
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
            moveToCode()
        }
    }

    private fun addObservers() {
        nameViewModel.eraseAll.observe(this) {
            if (it) {
                binding.etInputName.text = null
            }
        }
    }

    private fun moveToCode() {
        startActivity(Intent(this, CodeInputActivity::class.java))
    }
}
