package com.omg.cafebara.util.view

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.omg.cafebara.databinding.FragmentBaseDialogBinding
import com.omg.cafebara.util.base.BindingDialog

class OriginalDialog : BindingDialog() {

    private val binding: FragmentBaseDialogBinding
        get() = requireNotNull(_binding as FragmentBaseDialogBinding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentBaseDialogBinding.inflate(inflater, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return binding.root
    }

    override fun setTitle() {
        binding.tvDialogBaseTitle.text = title
    }

    override fun setContent() {
        binding.tvDialogBaseContent.text = content
    }

    override fun setContentVisible() {
        if (contentVisible == true) {
            binding.tvDialogBaseContent.visibility = View.VISIBLE
        } else {
            binding.tvDialogBaseContent.visibility = View.GONE
        }
    }

    override fun setDoBtnText() {
        binding.btnDialogBaseDo.text = doBtnText
    }

    override fun setCancelBtnText() {
        binding.btnDialogBaseCancel.text = cancelBtnText
    }

    override fun setDoBtnClick(action: () -> Unit) {
        binding.btnDialogBaseDo.setOnClickListener { action() }
    }

    override fun setCancelBtnClick(action: () -> Unit) {
        binding.btnDialogBaseCancel.setOnClickListener { action() }
    }
}