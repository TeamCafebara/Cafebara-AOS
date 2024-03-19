package com.omg.cafebara.presentation.employee.home.information

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.omg.cafebara.R
import com.omg.cafebara.databinding.FragmentHomeInformationListBinding
import com.omg.cafebara.util.base.BindingFragment

class HomeInformationListFragment :
    BindingFragment<FragmentHomeInformationListBinding>(R.layout.fragment_home_information_list) {

    private val viewModel by viewModels<HomeInformationListViewModel>()

    private var _noticeAdapter: NoticeAdapter? = null
    private val noticeAdapter
        get() = requireNotNull(_noticeAdapter)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        initMakeNoticeAdapter()
    }

    private fun initMakeNoticeAdapter() {
        _noticeAdapter = NoticeAdapter()
        binding.rcvHomeInformationList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noticeAdapter
        }

        setNoticeList()
    }

    private fun setNoticeList() {
        viewModel.mockNoticeData.observe(viewLifecycleOwner) {
            noticeAdapter.submitList(it)
        }
    }
}