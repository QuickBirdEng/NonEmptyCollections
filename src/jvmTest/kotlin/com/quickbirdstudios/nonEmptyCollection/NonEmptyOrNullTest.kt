package com.quickbirdstudios.nonEmptyCollection

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class NonEmptyOrNullTest {
    @Test
    fun nonEmptyOrNull_null() {
        val list = listOf<Int>()
        val set = setOf<Int>()
        val map = mapOf<Int, String>()

        assertNull(list.nonEmptyOrNull())
        assertNull(set.nonEmptyOrNull())
        assertNull(map.nonEmptyOrNull())
    }

    @Test
    fun nonEmptyOrNull_not_null() {
        val list = listOf(33, 44, 34543, -99)
        val set = setOf(-23, 34, 4)
        val map = mapOf(69 to "430", -12 to "Hallo")

        assertEquals<List<Int>?>(list, list.nonEmptyOrNull())
        assertEquals<Set<Int>?>(set, set.nonEmptyOrNull())
        assertEquals<Map<Int, String>?>(map, map.nonEmptyOrNull())
    }

}
