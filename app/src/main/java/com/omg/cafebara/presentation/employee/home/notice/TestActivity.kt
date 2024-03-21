package com.omg.cafebara.presentation.employee.home.notice

import android.content.Intent
import android.os.Bundle
import com.omg.cafebara.R
import com.omg.cafebara.databinding.ActivityTestBinding
import com.omg.cafebara.presentation.employee.home.notice.HomeNoticeActivity.Companion.NOTICE_ID
import com.omg.cafebara.presentation.employee.home.notice.HomeNoticeActivity.Companion.NOTICE_ID_DEFAULT
import com.omg.cafebara.util.base.BindingActivity

class TestActivity : BindingActivity<ActivityTestBinding>(R.layout.activity_test) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        clickNotice()
    }

    private fun clickNotice() {
        binding.tvTestNotice.setOnClickListener {
            changeNoticeView(NOTICE_ID_DEFAULT)
        }

        binding.tvTestNoticeDetail.setOnClickListener {
            changeNoticeView(2) // TODO: 해당하는 아이디
        }
    }

    private fun changeNoticeView(id: Int) {
        val intent = Intent(this, HomeNoticeActivity::class.java)
        intent.putExtra(NOTICE_ID, id)
        startActivity(intent)
    }
}
