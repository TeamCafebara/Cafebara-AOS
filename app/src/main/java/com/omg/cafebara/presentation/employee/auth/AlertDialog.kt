package com.omg.cafebara.presentation.employee.auth

import android.os.Bundle
import android.view.View
import com.omg.cafebara.R
import com.omg.cafebara.databinding.DialogMiddleBinding
import com.omg.cafebara.presentation.type.DialogType
import com.omg.cafebara.util.base.BindingDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlertDialog : BindingDialogFragment<DialogMiddleBinding>(R.layout.dialog_middle) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this.viewLifecycleOwner

        initLayout()
        addListeners()
    }

    private fun initLayout() {
        binding.dialogType = DialogType.ALERT
    }

    private fun addListeners() {
        binding.btnDialogLeft.setOnClickListener {
            dismiss()
        }

        binding.btnDialogRight.setOnClickListener {
            dismiss()
            //알림 설정하기
        }
    }
}
