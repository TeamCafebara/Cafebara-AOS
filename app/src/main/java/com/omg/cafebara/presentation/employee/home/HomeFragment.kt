package com.omg.cafebara.presentation.employee.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.omg.cafebara.R
import com.omg.cafebara.databinding.FragmentHomeBinding
import com.omg.cafebara.util.base.BindingFragment

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this
        binding.homeViewModel = homeViewModel
    }

}
