package com.quickbirdstudios.nonEmptyCollection.map

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class NonEmptyMapTest {
    @Test
    fun equals() {
        assertTrue {
            NonEmptyMap("f" to 1, mapOf("ff" to 2, "fff" to 3)) ==
                    mapOf("f" to 1, "ff" to 2, "fff" to 3)
        }
        assertFalse {
            NonEmptyMap("f" to 1, mapOf("ff" to 2, "fff" to 3)) ==
                    mapOf("f" to 1, "ff" to 2, "fff" to 4)
        }
    }

    @Test
    fun hashCodes() {
        assertEquals(
            mapOf("f" to 1, "ff" to 2, "fff" to 3).hashCode(),
            NonEmptyMap("f" to 1, mapOf("ff" to 2, "fff" to 3)).hashCode()
        )
        assertNotEquals(
            mapOf("f" to 1, "ff" to 2, "fff" to 3).hashCode(),
            NonEmptyMap("f" to 1, mapOf("ff" to 2, "ff" to 3)).hashCode()
        )
    }
}
