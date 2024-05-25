package com.omg.cafebara.util.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding
import com.omg.cafebara.util.view.OriginalDialog

abstract class BindingDialog: DialogFragment() {

    protected var _binding: ViewBinding? = null
    protected var title: String? = null
    protected var content: String? = null
    protected var contentVisible: Boolean? = null
    protected var doBtnText: String? = null
    protected var cancelBtnText: String? = null
    protected lateinit var doBtnAction: () -> Unit
    protected lateinit var cancelBtnAction: () -> Unit

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitle()
        setContent()
        setContentVisible()
        setDoBtnText()
        setCancelBtnText()
        setDoBtnClick { doBtnAction(); dismiss() }
        setCancelBtnClick{ cancelBtnAction(); dismiss() }
    }

    abstract fun setTitle()
    abstract fun setContent()
    abstract fun setContentVisible()
    abstract fun setDoBtnText()
    abstract fun setCancelBtnText()
    abstract fun setDoBtnClick(action: () -> Unit)
    abstract fun setCancelBtnClick(action: () -> Unit)

    class Builder() {
        fun build(
            title: String,
            content: String? = null,
            contentVisible: Boolean,
            doBtnText: String,
            cancelBtnText: String,
            doBtnAction: () -> Unit,
            cancelBtnAction: () -> Unit
        ): BindingDialog {
            val dialog = OriginalDialog()
            return dialog.apply {
                this.title = title
                this.content = content
                this.contentVisible = contentVisible
                this.doBtnText = doBtnText
                this.cancelBtnText = cancelBtnText
                this.doBtnAction = doBtnAction
                this.cancelBtnAction = cancelBtnAction
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        const val DIALOG = "DIALOG"
    }
}