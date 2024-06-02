package com.omg.cafebara.presentation.employee.mypage.addcafe

import android.os.Bundle
import androidx.activity.viewModels
import com.omg.cafebara.R
import com.omg.cafebara.databinding.ActivityMypageAddCafeBinding
import com.omg.cafebara.util.base.BindingActivity

class AddCafeActivity :
    BindingActivity<ActivityMypageAddCafeBinding>(R.layout.activity_mypage_add_cafe) {

    private val viewModel by viewModels<AddCafeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel

        initClickBackBtn()
        initInviteCodeObserver()
    }

    private fun initClickBackBtn() {
        binding.btnMypageAddCafeBack.setOnClickListener {
            finish()
        }
    }

    private fun initInviteCodeObserver() {
        viewModel.inviteCode.observe(this) {
            viewModel.checkIsCodeBtnEnabled()
        }
    }
}
