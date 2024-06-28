package com.omg.cafebara.presentation.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.omg.cafebara.R
import com.omg.cafebara.databinding.ActivitySignBinding
import com.omg.cafebara.presentation.employee.auth.EmployeeNameInputActivity
import com.omg.cafebara.presentation.employer.auth.EmployerNameInputActivity
import com.omg.cafebara.presentation.type.EmployType
import com.omg.cafebara.util.base.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignActivity : BindingActivity<ActivitySignBinding>(R.layout.activity_sign) {
    private val viewModel: SignViewModel by viewModels()
    private lateinit var employType: EmployType
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
            if (employType == EmployType.EMPLOYER)
                moveToEmployerName()
            else
                moveToEmployeeName()

        }
    }

    private fun addObservers() {
        // 직원인지, 사장님인지 구분하기
        viewModel.employType.observe(this) {
            if (it == EmployType.EMPLOYER) {
                employType = EmployType.EMPLOYER
            } else {
                employType = EmployType.EMPLOYEE
            }
        }
    }

    private fun moveToEmployeeName() {
        startActivity(Intent(this, EmployeeNameInputActivity::class.java))
    }

    private fun moveToEmployerName() {
        startActivity(Intent(this, EmployerNameInputActivity::class.java))
    }
}
