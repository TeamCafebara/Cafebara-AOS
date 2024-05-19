package com.omg.cafebara.presentation.employee.home.notice

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.omg.cafebara.R
import com.omg.cafebara.databinding.ActivityHomeNoticeBinding
import com.omg.cafebara.util.base.BindingActivity
import timber.log.Timber

class HomeNoticeActivity :
    BindingActivity<ActivityHomeNoticeBinding>(R.layout.activity_home_notice) {

    private val viewModel by viewModels<HomeNoticeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.toolbarHomeNotice.title = getString(R.string.home_information_toolbar)

        initClickBackBtn()
        initMakeNoticeView()
        homeToDetailNotice()
    }

    private fun initClickBackBtn() {
        binding.toolbarHomeNotice.ivBack.setOnClickListener {
            this.onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun initMakeNoticeView() {
        viewModel.setSelectedNoticeId(intent.getIntExtra(NOTICE_ID, NOTICE_ID_DEFAULT))

        makeFragment()
    }

    private fun makeFragment() {
        initFragment(HomeNoticeListFragment())

        viewModel.selectedNoticeId.observe(this) {
            if (viewModel.selectedNoticeId.value != NOTICE_ID_DEFAULT) {
                changeFragment(HomeNoticeDetailFragment())
            }
            Timber.d("selected notice Id -> $it")
        }
    }

    private fun initFragment(fragment: Fragment) {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_home_notice)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_home_notice, fragment)
                .commit()
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_home_notice, fragment)
            .addToBackStack(FRAGMENT_TAG)
            .commit()
    }

    private fun homeToDetailNotice() {
        val showDetailFragment = intent.getBooleanExtra(EXTRA_SHOW_DETAIL_FRAGMENT, false)
        val noticeId = intent.getIntExtra(EXTRA_SELECTED_NOTICE_ID, NOTICE_ID_DEFAULT)

        if (showDetailFragment) {
            viewModel.setSelectedNoticeId(noticeId)
            showDetailFragment()
        } else {
            initMakeNoticeView()
        }
    }

    private fun showDetailFragment() {
        changeFragment(HomeNoticeDetailFragment())
    }

    companion object {
        const val FRAGMENT_TAG = "FRAGMENT_TAG"
        const val NOTICE_ID = "noticeId"
        const val NOTICE_ID_DEFAULT = 0
        const val EXTRA_SELECTED_NOTICE_ID = "selected_notice_id"
        const val EXTRA_SHOW_DETAIL_FRAGMENT = "show_detail_fragment"
    }
}
