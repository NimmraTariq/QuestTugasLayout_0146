package com.example.questlayout0146

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Unit tests verifying data validity and record integrity in StudentRepository.
 */
class StudentDataTest {

    @Test
    fun studentRecordsKeepRequiredOrderAndStyles() {
        val studentList = studentUiModels()

        assertEquals(4, studentList.size)
        assertEquals(R.string.student_bambang_name, studentList[0].nameRes)
        assertNull(studentList[0].phoneRes)
        assertEquals(R.string.student_gibran_name, studentList[1].nameRes)
        assertEquals(R.string.student_zhila_name, studentList[2].nameRes)
        assertEquals(R.string.student_ahmad_name, studentList[3].nameRes)
        assertTrue(studentList[0].useScriptName)
    }

    @Test
    fun studentPhoneAndAddressResourcesAreValid() {
        val studentList = studentUiModels()

        studentList.forEach { student ->
            student.phoneRes?.let { assertTrue(it != 0) }
            assertTrue(student.addressRes != 0)
            assertTrue(student.nameColorRes != 0)
        }
    }

    @Test
    fun findStudentByNameResReturnsCorrectModel() {
        val student = StudentRepository.findStudentByNameRes(R.string.student_bambang_name)

        assertNotNull(student)
        assertEquals(R.string.student_bambang_name, student?.nameRes)
        assertTrue(student?.useScriptName == true)
    }
}
