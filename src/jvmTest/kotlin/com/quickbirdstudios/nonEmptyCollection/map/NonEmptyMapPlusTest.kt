package com.quickbirdstudios.nonEmptyCollection.map

import kotlin.test.Test
import kotlin.test.assertEquals

class NonEmptyMapPlusTest {

    @Test
    fun plusValue() {
        assertEquals(
            nonEmptyMapOf(1 to 'a', 2 to 'b', 3 to 'c'),
            nonEmptyMapOf(1 to 'a', 2 to 'b') + (3 to 'c')
        )
        assertEquals<NonEmptyMap<Int, Char>>(
            nonEmptyMapOf(1 to 'a', 2 to 'b', 3 to 'c'),
            mapOf(1 to 'a', 2 to 'b') + (3 to 'c')
        )
    }

    @Test
    fun plusValues() {
        assertEquals(
            nonEmptyMapOf(1 to 'a', 2 to 'b', 3 to 'c', 4 to 'd'),
            nonEmptyMapOf(1 to 'a', 2 to 'b') + mapOf(3 to 'c', 4 to 'd')
        )
        assertEquals<NonEmptyMap<Int, Char>>(
            nonEmptyMapOf(1 to 'a', 2 to 'b', 3 to 'c', 4 to 'd'),
            mapOf(1 to 'a', 2 to 'b') + nonEmptyMapOf(3 to 'c', 4 to 'd')
        )
        assertEquals(
            nonEmptyMapOf(1 to 'a', 2 to 'b', 3 to 'c', 4 to 'd'),
            nonEmptyMapOf(1 to 'a', 2 to 'b') + nonEmptyMapOf(3 to 'c', 4 to 'd')
        )
        assertEquals(
            nonEmptyMapOf(1 to 'a', 2 to 'b', 3 to 'c', 4 to 'd'),
            nonEmptyMapOf(1 to 'a', 2 to 'b') + listOf(3 to 'c', 4 to 'd')
        )
        assertEquals(
            nonEmptyMapOf(1 to 'a', 2 to 'b', 3 to 'c', 4 to 'd'),
            nonEmptyMapOf(1 to 'a', 2 to 'b') + sequenceOf(3 to 'c', 4 to 'd')
        )
        assertEquals(
            nonEmptyMapOf(1 to 'a', 2 to 'b', 3 to 'c', 4 to 'd'),
            nonEmptyMapOf(1 to 'a', 2 to 'b') + arrayOf(3 to 'c', 4 to 'd')
        )
    }
}
