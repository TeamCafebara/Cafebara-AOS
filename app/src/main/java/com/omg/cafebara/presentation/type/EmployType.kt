package com.omg.cafebara.presentation.type

import androidx.annotation.StringRes
import com.omg.cafebara.R

enum class EmployType(
    @StringRes val titleRes: Int,
) {
    EMPLOYER(
        R.string.name_view_input_name_employer
    ),
    EMPLOYEE(
        R.string.name_view_input_name_employee
    )
}
