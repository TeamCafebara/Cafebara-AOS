package com.omg.cafebara.presentation.dummy

import android.os.Bundle
import androidx.activity.viewModels
import com.omg.cafebara.R
import com.omg.cafebara.databinding.ActivityDummyBinding
import com.omg.cafebara.util.base.BindingActivity

class DummyActivity : BindingActivity<ActivityDummyBinding>(R.layout.activity_dummy) {
    private val dummyViewModel by viewModels<DummyViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = dummyViewModel
    }

    override fun onDestroy() {
        // TODO adapter를 사용한다면 adapter를 해제시켜주세요.(Fragment라면 onDestroyView에서 해제시켜주면 됩니다.) ex) binding.rvDummy.adpater = null
        super.onDestroy()
    }
}