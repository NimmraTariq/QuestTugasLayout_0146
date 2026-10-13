package com.example.questlayout0146

import androidx.annotation.ColorRes
import androidx.annotation.StringRes

/**
 * UI representation model for student list card items.
 */
data class StudentUiModel(
    @param:StringRes val nameRes: Int,
    @param:StringRes val phoneRes: Int? = null,
    @param:StringRes val addressRes: Int,
    @param:ColorRes val backgroundRes: Int,
    @param:ColorRes val nameColorRes: Int,
    @param:ColorRes val phoneColorRes: Int,
    @param:ColorRes val addressColorRes: Int,
    val useScriptName: Boolean = false
)
