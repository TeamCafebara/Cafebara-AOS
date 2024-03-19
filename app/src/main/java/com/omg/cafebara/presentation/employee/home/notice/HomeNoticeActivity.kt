package com.omg.cafebara.presentation.employee.home.notice

import android.os.Bundle
import androidx.activity.viewModels
import com.omg.cafebara.R
import com.omg.cafebara.databinding.ActivityHomeNoticeBinding
import com.omg.cafebara.util.base.BindingActivity

class HomeNoticeActivity :
    BindingActivity<ActivityHomeNoticeBinding>(R.layout.activity_home_notice) {

    private val viewModel by viewModels<HomeNoticeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.toolbarHomeNotice.title = getString(R.string.home_information_toolbar)

        initFragment()
    }

    private fun initFragment() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_home_notice)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_home_notice, HomeNoticeListFragment())
                .commit()
        }
    }
}