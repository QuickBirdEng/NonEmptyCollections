package com.quickbirdstudios.nonEmptyCollection.set

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class NonEmptySetOfTest {
    @Test
    fun nonEmptyListOf() {
        assertEquals(setOf(-12, -454, 56), nonEmptySetOf(-12, -454, 56))
        assertNotEquals(setOf(-12, -454, 56), nonEmptySetOf(-12, -454, 55))

        assertEquals(setOf(-12, -454, 56), nonEmptySetOf(-12, setOf(-454, 56)))
        assertNotEquals(setOf(-12, -454, 56), nonEmptySetOf(-12, setOf(-454, 55)))
    }

    @Test
    fun nonEmptyListOfNotNull() {
        assertEquals(setOf(-12, -454, 56), nonEmptySetOfNotNull(-12, -454, 56))
        assertNotEquals(setOf(-12, -454, 56), nonEmptySetOfNotNull(-12, -454, 55))

        assertEquals(setOf(-12, -454, 56), nonEmptySetOfNotNull(-12, setOf(-454, 56)))
        assertNotEquals(setOf(-12, -454, 56), nonEmptySetOfNotNull(-12, setOf(-454, 55)))

        assertEquals(setOf(-12, -454, 56), nonEmptySetOfNotNull(-12, -454, 56, null))
        assertNotEquals(setOf(-12, -454, 56), nonEmptySetOfNotNull(-12, null, -454, 55))

        assertEquals(
            setOf(-12, -454, 56),
            nonEmptySetOfNotNull(-12, setOf(-454, 56, null, null))
        )
        assertNotEquals(
            setOf(-12, -454, 56),
            nonEmptySetOfNotNull(-12, setOf(null, null, -454, 55))
        )
    }
}
