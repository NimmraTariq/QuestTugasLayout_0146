package com.example.questlayout0146

import org.junit.Assert.assertNotEquals
import org.junit.Test

/**
 * Contract tests ensuring resource allocations and color uniqueness across cards.
 */
class StudentResourceContractTest {

    @Test
    fun eachStudentHasDistinctCardBackgroundResource() {
        val bgResources = studentUiModels().map { model -> model.backgroundRes }

        assertNotEquals(bgResources[0], bgResources[1])
        assertNotEquals(bgResources[1], bgResources[2])
        assertNotEquals(bgResources[2], bgResources[3])
    }
}
