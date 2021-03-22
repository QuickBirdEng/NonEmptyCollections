package com.quickbirdstudios.nonEmptyCollection.list

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class NonEmptyListOfTest {
    @Test
    fun nonEmptyListOf() {
        assertEquals(listOf(-12, -454, 56), nonEmptyListOf(-12, -454, 56))
        assertNotEquals(listOf(-12, -454, 56), nonEmptyListOf(-12, -454, 55))

        assertEquals(listOf(-12, -454, 56), nonEmptyListOf(-12, listOf(-454, 56)))
        assertNotEquals(listOf(-12, -454, 56), nonEmptyListOf(-12, listOf(-454, 55)))
    }

    @Test
    fun nonEmptyListOfNotNull() {
        assertEquals(listOf(-12, -454, 56), nonEmptyListOfNotNull(-12, -454, 56))
        assertNotEquals(listOf(-12, -454, 56), nonEmptyListOfNotNull(-12, -454, 55))

        assertEquals(listOf(-12, -454, 56), nonEmptyListOfNotNull(-12, listOf(-454, 56)))
        assertNotEquals(listOf(-12, -454, 56), nonEmptyListOfNotNull(-12, listOf(-454, 55)))

        assertEquals(listOf(-12, -454, 56), nonEmptyListOfNotNull(-12, -454, 56, null))
        assertNotEquals(listOf(-12, -454, 56), nonEmptyListOfNotNull(-12, null, -454, 55))

        assertEquals(
            listOf(-12, -454, 56),
            nonEmptyListOfNotNull(-12, listOf(-454, 56, null, null))
        )
        assertNotEquals(
            listOf(-12, -454, 56),
            nonEmptyListOfNotNull(-12, listOf(null, null, -454, 55))
        )
    }
}
