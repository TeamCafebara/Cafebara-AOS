package com.omg.cafebara.presentation.employee.mypage.leavecafe

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.omg.cafebara.R
import com.omg.cafebara.databinding.ActivityMypageLeaveCafeBinding
import com.omg.cafebara.util.base.BindingActivity

class LeaveCafeActivity : BindingActivity<ActivityMypageLeaveCafeBinding>(R.layout.activity_mypage_leave_cafe) {

    private val viewModel by viewModels<LeaveCafeViewModel>()

    private var _leaveCafeAdapter: LeaveCafeAdapter? = null
    private val leaveCafeAdapter
        get() = requireNotNull(_leaveCafeAdapter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel

        initClickBackBtn()
        initMakeCafeAdapter()
    }

    private fun initClickBackBtn() {
        binding.btnMypageLeaveCafeBack.setOnClickListener {
            finish()
        }
    }

    private fun initMakeCafeAdapter() {
        _leaveCafeAdapter = LeaveCafeAdapter()
        binding.rcvMypageLeaveCafeList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = leaveCafeAdapter
        }

        setCafeList()
    }

    private fun setCafeList() {
        viewModel.mockCafeList.observe(this) {
            leaveCafeAdapter.submitList(it)
        }
    }
}