package com.omg.cafebara.presentation.employee.mypage.leavecafe

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.omg.cafebara.R
import com.omg.cafebara.databinding.ActivityMypageLeaveCafeBinding
import com.omg.cafebara.domain.model.CafeList
import com.omg.cafebara.util.base.BindingActivity
import com.omg.cafebara.util.base.BindingDialog
import timber.log.Timber

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
        _leaveCafeAdapter = LeaveCafeAdapter().apply {
            setOnItemClickListener(object : LeaveCafeAdapter.OnItemClickListener {
                override fun onItemClick(item: CafeList, position: Int) {
                    Timber.d("클릭한 업장 -> ${item.cafeId}")
                    viewModel.setLeaveCafeBtnEnabled(true)
                    clickLeaveCafeBtn()
                }
            })
        }
        binding.rcvMypageLeaveCafeList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = leaveCafeAdapter
        }

        setCafeList()
    }

    private fun clickLeaveCafeBtn() {
        binding.btnMypageLeaveCafe.setOnClickListener {
            BindingDialog.Builder().build(
                title = "업장 탈퇴",
                content = "선택한 업장을 탈퇴하실 건가요?\n탈퇴한 업장은 초대코드로 다시 추가 가능해요",
                contentVisible = true,
                cancelBtnText = "할래요",
                doBtnText = "안할래요",
                doBtnAction = {},
                cancelBtnAction = {}
            ).show(supportFragmentManager, BindingDialog.DIALOG)
        }
    }

    private fun setCafeList() {
        viewModel.mockCafeList.observe(this) {
            leaveCafeAdapter.submitList(it)
        }
    }
}