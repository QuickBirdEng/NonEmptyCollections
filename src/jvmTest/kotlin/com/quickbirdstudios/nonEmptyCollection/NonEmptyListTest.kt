package com.quickbirdstudios.nonEmptyCollection

import com.quickbirdstudios.nonEmptyCollection.list.nonEmptyListOf
import kotlin.test.Test
import kotlin.test.assertEquals

class NonEmptyListTest {

    /**
     * First dummy test
     */
    @Test
    fun test() {
        val squared = nonEmptyListOf(1, 2, 3).map { value -> value * value }

        assertEquals(listOf(1, 4, 9), squared)
    }
}
