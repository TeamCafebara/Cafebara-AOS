package com.omg.cafebara.presentation.employee.mypage

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.omg.cafebara.R
import com.omg.cafebara.databinding.FragmentMypageTempBinding
import com.omg.cafebara.presentation.employee.mypage.addcafe.AddCafeActivity
import com.omg.cafebara.presentation.employee.mypage.leavecafe.LeaveCafeActivity
import com.omg.cafebara.util.base.BindingFragment

class MyPageTempFragment :
    BindingFragment<FragmentMypageTempBinding>(R.layout.fragment_mypage_temp) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickLeaveCafeBtn()
        initClickAddCafeBtn()
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
}