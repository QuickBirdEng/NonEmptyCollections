@file:OptIn(UnsafeNonEmptyCollectionApi::class)

package com.quickbirdstudios.nonEmptyCollection.unsafe

import com.quickbirdstudios.nonEmptyCollection.assertThrows
import com.quickbirdstudios.nonEmptyCollection.list.nonEmptyListOf
import com.quickbirdstudios.nonEmptyCollection.map.NonEmptyMap
import com.quickbirdstudios.nonEmptyCollection.map.nonEmptyMapOf
import com.quickbirdstudios.nonEmptyCollection.set.nonEmptySetOf
import kotlin.test.Test
import kotlin.test.assertEquals

class ToNonEmptyCollectionTest {

    @Test
    fun toNonEmptyList() {
        assertEquals(nonEmptyListOf(15, 2), listOf(15, 2).toNonEmptyList())
        assertThrows<IllegalArgumentException> {
            emptyList<String>().toNonEmptyList()
        }
    }

    @Test
    fun toNonEmptySet() {
        assertEquals(nonEmptySetOf(15, 2), listOf(15, 2).toNonEmptySet())
        assertEquals(nonEmptySetOf(15, 2), setOf(15, 2).toNonEmptySet())

        assertThrows<IllegalArgumentException> {
            emptyList<String>().toNonEmptySet()
        }
        assertThrows<IllegalArgumentException> {
            emptySet<String>().toNonEmptySet()
        }
    }

    @Test
    fun toNonEmptyMap() {
        assertEquals<NonEmptyMap<Int, Char>>(
            nonEmptyMapOf(15 to 't', 2 to 'P'),
            listOf(15 to 't', 2 to 'P').toNonEmptyMap()
        )
        assertEquals<NonEmptyMap<Int, Char>>(
            nonEmptyMapOf(15 to 't', 2 to 'P'),
            mapOf(15 to 't', 2 to 'P').toNonEmptyMap()
        )

        assertThrows<IllegalArgumentException> {
            emptyList<Pair<String, Float>>().toNonEmptyMap()
        }
        assertThrows<IllegalArgumentException> {
            emptyMap<String, Double>().toNonEmptyMap()
        }
    }

}
