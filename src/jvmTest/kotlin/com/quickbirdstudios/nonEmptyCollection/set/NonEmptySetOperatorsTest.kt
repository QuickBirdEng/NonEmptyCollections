package com.quickbirdstudios.nonEmptyCollection.set

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection
import com.quickbirdstudios.nonEmptyCollection.assertOperationEquals
import com.quickbirdstudios.nonEmptyCollection.unsafe.UnsafeNonEmptyCollectionApi
import com.quickbirdstudios.nonEmptyCollection.unsafe.toNonEmptyList
import com.quickbirdstudios.nonEmptyCollection.unsafe.toNonEmptySet
import kotlin.test.Test
import kotlin.test.assertEquals

class NonEmptySetOperatorsTest {
    @OptIn(UnsafeNonEmptyCollectionApi::class)
    @Test
    fun toNonEmptySet() {
        assertOperationEquals(
            Iterable<Int>::toNonEmptySet,
            NonEmptyCollection<Int>::toNonEmptySet,
            23, 324334, -3434
        )
    }

    @Test
    fun onEach() {
        val mutableSet = mutableSetOf<String>()

        assertSetOperationEquals(
            Set<String>::onEach,
            NonEmptySet<String>::onEach,
            { value -> mutableSet.add(value) },
            "dffd", "324334", "3434", "Stefan", "234234"
        )
        assertEquals(5, mutableSet.size)
    }

    @Test
    fun onEachIndexed() {
        val mutableSet = mutableSetOf<Int>()

        assertSetOperationEquals(
            Set<String>::onEachIndexed,
            NonEmptySet<String>::onEachIndexed,
            { index, _ -> mutableSet.add(index) },
            "dffd", "324334", "3434", "Stefan", "234234"
        )
        assertEquals(5, mutableSet.size)
    }

    @Test
    fun union() {
        assertOperationEquals(
            Iterable<String>::union,
            NonEmptyCollection<String>::union,
            listOf("dffd", "324334"),
            "3434", "Stefan", "234234"
        )
    }
}
