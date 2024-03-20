package com.omg.cafebara.presentation.employee.home.notice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.omg.cafebara.R
import com.omg.cafebara.databinding.FragmentHomeNoticeListBinding
import com.omg.cafebara.util.base.BindingFragment

class HomeNoticeListFragment :
    BindingFragment<FragmentHomeNoticeListBinding>(R.layout.fragment_home_notice_list) {

//    private val viewModel by viewModels<HomeNoticeListViewModel>()
    private lateinit var viewModel: HomeNoticeViewModel

    private var _noticeAdapter: NoticeAdapter? = null
    private val noticeAdapter
        get() = requireNotNull(_noticeAdapter)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[HomeNoticeViewModel::class.java]
        binding.viewModel = viewModel

        initMakeNoticeAdapter()
    }

    private fun initMakeNoticeAdapter() {
        _noticeAdapter = NoticeAdapter()
        binding.rcvHomeNoticeList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noticeAdapter
        }

        setNoticeList()
        selectNotice()
    }

    private fun setNoticeList() {
        viewModel.mockNoticeData.observe(viewLifecycleOwner) {
            noticeAdapter.submitList(it)
        }
    }

    private fun selectNotice() {
        noticeAdapter.setOnNoticeDataClickListener {
            viewModel.setSelectedNoticeId(it.noticeId)
        }
    }
}