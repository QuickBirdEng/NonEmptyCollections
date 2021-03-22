package com.quickbirdstudios.nonEmptyCollection.list

import kotlin.test.Test
import kotlin.test.assertEquals

class NonEmptyListPlusTest {

    @Test
    fun plusValue() {
        assertEquals(
            nonEmptyListOf(1, 2, 3),
            nonEmptyListOf(1, 2) + 3
        )
        assertEquals(
            nonEmptyListOf(1, 2, 3),
            listOf(1, 2) + 3
        )
    }

    @Test
    fun plusValues() {
        assertEquals(
            nonEmptyListOf(12, 22, 33, 43),
            nonEmptyListOf(12, 22) + listOf(33, 43)
        )
        assertEquals(
            nonEmptyListOf(12, 22, 33, 43),
            listOf(12, 22) + nonEmptyListOf(33, 43)
        )
        assertEquals(
            nonEmptyListOf(12, 22, 33, 43),
            nonEmptyListOf(12, 22) + nonEmptyListOf(33, 43)
        )
        assertEquals(
            nonEmptyListOf(12, 22, 33, 43),
            nonEmptyListOf(12, 22) + (listOf(33, 43) as Iterable<Int>)
        )
        assertEquals(
            nonEmptyListOf(12, 22, 33, 43),
            nonEmptyListOf(12, 22) + sequenceOf(33, 43)
        )
        assertEquals(
            nonEmptyListOf(12, 22, 33, 43),
            nonEmptyListOf(12, 22) + arrayOf(33, 43)
        )
    }
}
