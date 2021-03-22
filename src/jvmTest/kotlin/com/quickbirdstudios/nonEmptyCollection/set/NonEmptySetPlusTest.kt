package com.quickbirdstudios.nonEmptyCollection.set

import kotlin.test.Test
import kotlin.test.assertEquals

class NonEmptySetPlusTest {

    @Test
    fun plusValue() {
        assertEquals(
            nonEmptySetOf(1, 2, 3),
            nonEmptySetOf(1, 2) + 3
        )
        assertEquals(
            nonEmptySetOf(1, 2, 3),
            setOf(1, 2) + 3
        )
    }

    @Test
    fun plusValues() {
        assertEquals(
            nonEmptySetOf(12, 22, 33, 43),
            nonEmptySetOf(12, 22) + setOf(33, 43)
        )
        assertEquals(
            nonEmptySetOf(12, 22, 33, 43),
            setOf(12, 22) + nonEmptySetOf(33, 43)
        )
        assertEquals(
            nonEmptySetOf(12, 22, 33, 43),
            nonEmptySetOf(12, 22) + nonEmptySetOf(33, 43)
        )
        assertEquals(
            nonEmptySetOf(12, 22, 33, 43),
            nonEmptySetOf(12, 22) + (setOf(33, 43) as Iterable<Int>)
        )
        assertEquals(
            nonEmptySetOf(12, 22, 33, 43),
            nonEmptySetOf(12, 22) + sequenceOf(33, 43)
        )
        assertEquals(
            nonEmptySetOf(12, 22, 33, 43),
            nonEmptySetOf(12, 22) + arrayOf(33, 43)
        )
    }
}
