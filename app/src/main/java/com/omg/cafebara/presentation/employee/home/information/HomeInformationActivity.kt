package com.omg.cafebara.presentation.employee.home.information

import android.os.Bundle
import androidx.activity.viewModels
import com.omg.cafebara.R
import com.omg.cafebara.databinding.ActivityHomeInformationBinding
import com.omg.cafebara.util.base.BindingActivity

class HomeInformationActivity :
    BindingActivity<ActivityHomeInformationBinding>(R.layout.activity_home_information) {

    private val viewModel by viewModels<HomeInformationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.toolbarHomeInformation.title = getString(R.string.home_information_toolbar)

        initFragment()
    }

    private fun initFragment() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_home_information)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_home_information, HomeInformationListFragment())
                .commit()
        }
    }
}