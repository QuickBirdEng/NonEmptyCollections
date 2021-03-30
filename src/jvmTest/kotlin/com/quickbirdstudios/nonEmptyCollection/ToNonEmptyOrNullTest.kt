package com.quickbirdstudios.nonEmptyCollection

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ToNonEmptyOrNullTest {
    @Test
    fun toNonEmptyOrNull_null() {
        val list = listOf<Int>()
        val set = setOf<Int>()
        val map = mapOf<Int, String>()

        assertNull(list.toNonEmptyListOrNull())
        assertNull(set.toNonEmptyMapOrNull())
        assertNull(map.toNonEmptyMapOrNull())
    }

    @Test
    fun toNonEmptyOrNull_not_null() {
        val list = listOf(33, 44, 34543, -99)
        val set = setOf(-23, 34, 4)
        val map = mapOf(69 to "430", -12 to "Hallo")

        assertEquals<List<Int>?>(list, list.toNonEmptyListOrNull())
        assertEquals<Set<Int>?>(set, set.toNonEmptyMapOrNull())
        assertEquals<Map<Int, String>?>(map, map.toNonEmptyMapOrNull())
    }
}
