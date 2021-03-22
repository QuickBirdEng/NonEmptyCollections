package com.quickbirdstudios.nonEmptyCollection.list

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class NonEmptyListTest {
    @Test
    fun equals() {
        assertTrue { NonEmptyList("f", listOf("ff", "fff")) == listOf("f", "ff", "fff") }
        assertFalse { NonEmptyList("f", listOf("ff", "fff")) == listOf("ff", "fff") }
    }

    @Test
    fun hashCodes() {
        assertEquals(
            listOf("f", "ff", "fff").hashCode(),
            NonEmptyList("f", listOf("ff", "fff")).hashCode()
        )
        assertNotEquals(
            listOf("f", "ff", "fff").hashCode(),
            NonEmptyList("f", listOf("ff", "eff")).hashCode()
        )
    }
}
