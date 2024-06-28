package com.omg.cafebara.presentation.employer.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.omg.cafebara.R
import com.omg.cafebara.databinding.ActivityInputNameBinding
import com.omg.cafebara.presentation.employee.auth.NameInputViewModel
import com.omg.cafebara.presentation.type.EmployType
import com.omg.cafebara.util.base.BindingActivity
import com.omg.cafebara.util.context.hideKeyboard

class EmployerStoreNameInputActivity :
    BindingActivity<ActivityInputNameBinding>(R.layout.activity_input_name) {
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
        binding.employType = EmployType.EMPLOYER_GET_STORE_NAME
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
            moveToGenerateCode()
        }
    }

    private fun addObservers() {
        nameViewModel.eraseAll.observe(this) {
            if (it) {
                binding.etInputName.text = null
            }
        }
        nameViewModel.name.observe(this){
            if(it.length > 18){
                // todo
            }
        }
    }

    private fun moveToGenerateCode() {
        startActivity(Intent(this, EmployerGenerateCodeActivity::class.java))
    }
}