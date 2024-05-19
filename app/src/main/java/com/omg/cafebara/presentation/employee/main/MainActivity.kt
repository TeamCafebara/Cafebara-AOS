package com.omg.cafebara.presentation.employee.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.omg.cafebara.R
import com.omg.cafebara.databinding.ActivityMainBinding
import com.omg.cafebara.presentation.employee.home.HomeFragment
import com.omg.cafebara.presentation.employee.mypage.MyPageFragment
import com.omg.cafebara.presentation.employee.schedule.ScheduleFragment
import com.omg.cafebara.presentation.employee.todo.TodoFragment
import com.omg.cafebara.presentation.employee.work.WorkFragment
import com.omg.cafebara.util.base.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val homeViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = homeViewModel
        // binding.lifecycleOwner = this
        // binding에서 LiveData를 사용할 경우 해당 코드 필요
        initLayout()
    }

    private fun initLayout() {
        val isTodoRequested = intent.getStringExtra(TODO_FRAGMENT) == TODO_FRAGMENT
        val isScheduleRequested = intent.getStringExtra(SCHEDULE_FRAGMENT) == SCHEDULE_FRAGMENT
        val isWorkRequested = intent.getStringExtra(WORK_FRAGMENT) == WORK_FRAGMENT
        val isMyPageRequested = intent.getStringExtra(MY_PAGE_FRAGMENT) == MY_PAGE_FRAGMENT

        val initialFragment = if (isTodoRequested) {
            navigateTo<TodoFragment>()
            R.id.menu_todo
        } else if (isScheduleRequested) {
            navigateTo<ScheduleFragment>()
            R.id.menu_schedule
        } else if (isWorkRequested) {
            navigateTo<WorkFragment>()
            R.id.menu_work
        } else if (isMyPageRequested) {
            navigateTo<MyPageFragment>()
            R.id.menu_my_page
        } else {
            navigateTo<HomeFragment>()
            R.id.menu_home
        }

        binding.bnvHome.setOnItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.menu_home -> navigateTo<HomeFragment>()
                R.id.menu_todo -> navigateTo<TodoFragment>()
                R.id.menu_schedule -> navigateTo<ScheduleFragment>()
                R.id.menu_work -> navigateTo<WorkFragment>()
                R.id.menu_my_page -> navigateTo<MyPageFragment>()
            }
            true
        }

        binding.bnvHome.apply {
            menu.findItem(initialFragment)?.isChecked = true
            itemIconTintList = null
        }
    }

    private fun addListeners() {
        TODO("Not yet implemented")
    }

    private fun addObservers() {
        TODO("Not yet implemented")
    }

    private inline fun <reified T : Fragment> navigateTo() {
        supportFragmentManager.commit {
            replace<T>(R.id.fcv_home_container, T::class.java.canonicalName)
        }
    }

    companion object {
        const val TODO_FRAGMENT = "TodoFragment"
        const val SCHEDULE_FRAGMENT = "ScheduleFragment"
        const val WORK_FRAGMENT = "WorkFragment"
        const val MY_PAGE_FRAGMENT = "MyPageFragment"
    }
}
