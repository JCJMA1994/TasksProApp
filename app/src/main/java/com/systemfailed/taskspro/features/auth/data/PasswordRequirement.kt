package com.systemfailed.taskspro.features.auth.data

import androidx.annotation.StringRes
import com.systemfailed.taskspro.R

enum class PasswordRequirement(
    @StringRes val label: Int
) {
    CAPITAL_LETTER(R.string.password_requirement_capital),
    NUMBER(R.string.password_requirement_digital),
    EIGHT_CHARACTERS(R.string.password_requiremenmt_character)
}