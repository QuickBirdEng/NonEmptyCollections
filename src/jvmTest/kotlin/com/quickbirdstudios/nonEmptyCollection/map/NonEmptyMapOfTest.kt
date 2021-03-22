package com.quickbirdstudios.nonEmptyCollection.map

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class NonEmptyMapOfTest {
    @Test
    fun nonEmptyListOf() {
        assertEquals(
            mapOf(-12 to "1", -454 to "b", 56 to "c"),
            nonEmptyMapOf(-12 to "1", -454 to "b", 56 to "c")
        )
        assertNotEquals(
            mapOf(-12 to "1", -454 to "b", 56 to "c"),
            nonEmptyMapOf(-12 to "1", -454 to "a", 56 to "c")
        )

        assertEquals(
            mapOf(-12 to "1", -454 to "b", 56 to "c"),
            nonEmptyMapOf(-12 to "1", mapOf(-454 to "b", 56 to "c"))
        )
        assertNotEquals(
            mapOf(-12 to "1", -454 to "b", 56 to "c"),
            nonEmptyMapOf(-12 to "1", mapOf(-44 to "b", 56 to "c"))
        )
    }
}
