package com.omg.cafebara.presentation.type

import androidx.annotation.StringRes
import com.omg.cafebara.R

enum class DialogType(
    @StringRes val titleRes: Int,
    @StringRes val contextRes: Int,
    @StringRes val leftBtnRes: Int,
    @StringRes val rightBtnRes: Int,
) {
    ALERT(
        R.string.dialog_middle_alert_title,
        R.string.dialog_middle_alert_context,
        R.string.dialog_middle_left_btn,
        R.string.dialog_middle_right_btn,
    )
}