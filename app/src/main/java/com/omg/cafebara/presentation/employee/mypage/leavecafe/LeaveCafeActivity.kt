package com.omg.cafebara.presentation.employee.mypage.leavecafe

import android.os.Bundle
import com.omg.cafebara.R
import com.omg.cafebara.databinding.ActivityMypageLeaveCafeBinding
import com.omg.cafebara.util.base.BindingActivity

class LeaveCafeActivity : BindingActivity<ActivityMypageLeaveCafeBinding>(R.layout.activity_mypage_leave_cafe) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initClickBackBtn()
    }

    private fun initClickBackBtn() {
        binding.btnMypageLeaveCafeBack.setOnClickListener {
            finish()
        }
    }
}