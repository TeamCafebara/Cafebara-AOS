package com.omg.cafebara.presentation.employee.home.information

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.omg.cafebara.R
import com.omg.cafebara.databinding.FragmentHomeInformationListBinding
import com.omg.cafebara.util.base.BindingFragment

class HomeInformationListFragment: BindingFragment<FragmentHomeInformationListBinding>(R.layout.fragment_home_information_list) {

    private val viewModel by viewModels<HomeInformationListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }
}