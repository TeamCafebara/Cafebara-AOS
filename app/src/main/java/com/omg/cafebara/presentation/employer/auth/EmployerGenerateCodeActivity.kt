package com.omg.cafebara.presentation.employer.auth

import android.os.Bundle
import com.omg.cafebara.R
import com.omg.cafebara.databinding.ActivityGenerateCodeBinding
import com.omg.cafebara.util.base.BindingActivity

class EmployerGenerateCodeActivity :
    BindingActivity<ActivityGenerateCodeBinding>(R.layout.activity_generate_code) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
    }

    private fun initLayout(){
        // TODO 서버에서 받아온 코드가 필요
    }
}