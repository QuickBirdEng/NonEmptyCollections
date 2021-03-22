package com.quickbirdstudios.nonEmptyCollection.set

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class NonEmptySetTest {
    @Test
    fun equals() {
        assertTrue { NonEmptySet("f", setOf("ff", "fff")) == setOf("f", "ff", "fff") }
        assertFalse { NonEmptySet("f", setOf("ff", "fff")) == setOf("ff", "fff") }
    }

    @Test
    fun hashCodes() {
        assertEquals(
            setOf("f", "ff", "fff").hashCode(),
            NonEmptySet("f", setOf("ff", "fff")).hashCode()
        )
        assertNotEquals(
            setOf("f", "ff", "fff").hashCode(),
            NonEmptySet("f", setOf("ff", "eff")).hashCode()
        )
    }
}
