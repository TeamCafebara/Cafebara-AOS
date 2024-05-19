package com.omg.cafebara.presentation.employee.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.omg.cafebara.R
import com.omg.cafebara.databinding.FragmentHomeBinding
import com.omg.cafebara.presentation.employee.home.notice.HomeNoticeActivity
import com.omg.cafebara.presentation.employee.home.notice.HomeNoticeDetailFragment
import com.omg.cafebara.presentation.employee.home.notice.HomeNoticeListFragment
import com.omg.cafebara.presentation.employee.todo.TodoFragment
import com.omg.cafebara.util.base.BindingFragment
import timber.log.Timber

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this
        binding.homeViewModel = homeViewModel

        moveToActivity()
    }

    private fun moveToActivity() {
        moveToMoreNotice()
        moveToDetailFragment()
        moveToTodo()
    }

    private fun moveToMoreNotice() {
        binding.tvHomeStaffNoticeMore.setOnClickListener {
            val intent = Intent(requireContext(), HomeNoticeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun moveToDetailFragment() {
        val noticeId = 1

        binding.ivHomeStaffNoticeArrowFirst.setOnClickListener {
            moveToDetailNotice(noticeId)
        }

        binding.ivHomeStaffNoticeArrowSecond.setOnClickListener {
            moveToDetailNotice(noticeId)
        }

        binding.ivHomeStaffNoticeArrowNone.setOnClickListener {
            moveToDetailNotice(noticeId)
        }
    }

//    private fun moveToDetailFragment() {
//        homeViewModel.selectedNoticeId.observe(viewLifecycleOwner) { noticeId ->
//            if (noticeId != HomeNoticeActivity.NOTICE_ID_DEFAULT) {
//                binding.ivHomeStaffNoticeArrowFirst.setOnClickListener {
//                    moveToDetailNotice(noticeId)
//                }
//
//                binding.ivHomeStaffNoticeArrowSecond.setOnClickListener {
//                    moveToDetailNotice(noticeId)
//                }
//
//            } else {
//                binding.ivHomeStaffNoticeArrowNone.setOnClickListener {
//                    moveToDetailNotice(noticeId)
//                }
//            }
//            Timber.d("selected notice Id -> $noticeId")
//        }
//    }

    private fun moveToDetailNotice(noticeId: Int) {
        val intent = Intent(requireContext(), HomeNoticeActivity::class.java).apply {
            putExtra("selected_notice_id", noticeId)
            putExtra("show_detail_fragment", true)
        }
        startActivity(intent)
    }

    private fun moveToTodo() {
        binding.clHomeStaffMissionCheck.setOnClickListener {
            val fragment = TodoFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fcv_home_container, fragment)
            transaction.commit()
        }
    }
}
