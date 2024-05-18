package com.omg.cafebara.presentation.employee.mypage

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import com.omg.cafebara.R
import com.omg.cafebara.databinding.FragmentMypageTempBinding
import com.omg.cafebara.presentation.employee.mypage.addcafe.AddCafeActivity
import com.omg.cafebara.presentation.employee.mypage.leavecafe.LeaveCafeActivity
import com.omg.cafebara.util.base.BindingDialog
import com.omg.cafebara.util.base.BindingDialog.Companion.DIALOG
import com.omg.cafebara.util.base.BindingFragment

class MyPageTempFragment :
    BindingFragment<FragmentMypageTempBinding>(R.layout.fragment_mypage_temp) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickLeaveCafeBtn()
        initClickAddCafeBtn()
        clickLogOut()
        clickWithDraw()
    }

    private fun initClickLeaveCafeBtn() {
        val intent = Intent(requireActivity(), LeaveCafeActivity::class.java)
        binding.layoutMypageLeaveCafe.setOnClickListener {
            startActivity(intent)
        }
    }

    private fun initClickAddCafeBtn() {
        val intent = Intent(requireActivity(), AddCafeActivity::class.java)
        binding.layoutMypageAddCafe.setOnClickListener {
            startActivity(intent)
        }
    }

    private fun clickLogOut() {
        binding.layoutMypageLogout.setOnClickListener {
            BindingDialog.Builder().build(
                title = "정말 로그아웃하실 건가요?",
                contentVisible = false,
                cancelBtnText = "할래요",
                doBtnText = "안할래요",
                doBtnAction = {},
                cancelBtnAction = {}
            ).show(parentFragmentManager, DIALOG)
        }
    }

    private fun clickWithDraw() {
        binding.layoutMypageWithdraw.setOnClickListener {
            BindingDialog.Builder().build(
                title = "회원탈퇴",
                content = "정말 카페바라를 탈퇴하실 건가요?\n탈퇴 시, 회원님의 정보가 전부 삭제돼요",
                contentVisible = true,
                cancelBtnText = "할래요",
                doBtnText = "안할래요",
                doBtnAction = {},
                cancelBtnAction = {}
            ).show(parentFragmentManager, DIALOG)
        }
    }
}