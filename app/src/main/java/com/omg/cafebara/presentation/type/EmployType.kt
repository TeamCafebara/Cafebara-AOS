package com.omg.cafebara.presentation.type

import androidx.annotation.StringRes
import com.omg.cafebara.R

enum class EmployType(
    @StringRes val titleRes: Int,
    @StringRes val hintRes: Int,
) {
    EMPLOYER(
        R.string.name_view_input_name_employer,
        R.string.name_view_input_hint_employer
    ),
    EMPLOYEE(
        R.string.name_view_input_name_employee,
        R.string.name_view_input_hint_employee
    ),
    EMPLOYER_GET_STORE_NAME(
        R.string.name_view_input_store_name_employer,
        R.string.store_name_view_input_hint
    ),
}
