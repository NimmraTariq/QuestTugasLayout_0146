package com.example.questlayout0146

/**
 * Repository object providing student UI models data source.
 */
object StudentRepository {

    fun getStudents(): List<StudentUiModel> {
        return listOf(
            StudentUiModel(
                nameRes = R.string.student_bambang_name,
                phoneRes = null,
                addressRes = R.string.student_bambang_address,
                backgroundRes = R.color.card_bambang,
                nameColorRes = R.color.text_white,
                phoneColorRes = R.color.text_yellow,
                addressColorRes = R.color.text_yellow,
                useScriptName = true,
            ),
            StudentUiModel(
                nameRes = R.string.student_gibran_name,
                phoneRes = R.string.student_gibran_phone,
                addressRes = R.string.student_gibran_address,
                backgroundRes = R.color.card_gibran,
                nameColorRes = R.color.text_white,
                phoneColorRes = R.color.text_cyan,
                addressColorRes = R.color.text_yellow,
                useScriptName = false,
            ),
            StudentUiModel(
                nameRes = R.string.student_zhila_name,
                phoneRes = R.string.student_zhila_phone,
                addressRes = R.string.student_zhila_address,
                backgroundRes = R.color.card_zhila,
                nameColorRes = R.color.text_white,
                phoneColorRes = R.color.text_cyan,
                addressColorRes = R.color.text_white,
                useScriptName = false,
            ),
            StudentUiModel(
                nameRes = R.string.student_ahmad_name,
                phoneRes = R.string.student_ahmad_phone,
                addressRes = R.string.student_ahmad_address,
                backgroundRes = R.color.card_ahmad,
                nameColorRes = R.color.text_white,
                phoneColorRes = R.color.text_cyan,
                addressColorRes = R.color.text_white,
                useScriptName = false,
            ),
        )
    }

    fun findStudentByNameRes(nameRes: Int): StudentUiModel? {
        return getStudents().firstOrNull { it.nameRes == nameRes }
    }
}

fun studentUiModels(): List<StudentUiModel> = StudentRepository.getStudents()
