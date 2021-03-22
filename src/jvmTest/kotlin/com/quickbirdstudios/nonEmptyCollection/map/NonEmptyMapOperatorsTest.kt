package com.quickbirdstudios.nonEmptyCollection.map

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection
import com.quickbirdstudios.nonEmptyCollection.assertOperationEquals
import com.quickbirdstudios.nonEmptyCollection.unsafe.UnsafeNonEmptyCollectionApi
import com.quickbirdstudios.nonEmptyCollection.unsafe.toNonEmptyMap
import kotlin.test.Test
import kotlin.test.assertEquals

class NonEmptyMapOperatorsTest {
    @OptIn(UnsafeNonEmptyCollectionApi::class)
    @Test
    fun toNonEmptyMap() {
        assertOperationEquals(
            Iterable<Pair<Int, Char>>::toNonEmptyMap,
            NonEmptyCollection<Pair<Int, Char>>::toNonEmptyMap,
            23 to '8', 324334 to 'h', -3434 to 'k'
        )
    }

    @Test
    fun onEach() {
        val mutableMap = mutableMapOf<Int, Unit>()

        assertMapOperationEquals(
            Map<String, Int>::onEach,
            NonEmptyMap<String, Int>::onEach,
            { entry -> mutableMap[entry.value] = Unit },
            "dffd" to 1, "324334" to 2, "3434" to 3, "Stefan" to 4, "234234" to 17
        )
        assertEquals(5, mutableMap.size)
    }

    @Test
    fun onEachIndexed() {
        val mutableMap = mutableMapOf<Int, Int>()

        assertMapOperationEquals(
            Map<String, Int>::onEachIndexed,
            NonEmptyMap<String, Int>::onEachIndexed,
            { index, entry -> mutableMap[entry.value] = index },
            "dffd" to 1, "324334" to 2, "3434" to 3, "Stefan" to 4, "234234" to 17
        )
        assertEquals(5, mutableMap.size)
    }

    @Test
    fun associate() {
        assertOperationEquals(
            Iterable<String>::associate,
            NonEmptyCollection<String>::associate,
            { value -> value to value.length },
            "dffd", "324334", "3434", "Stefan", "234234"
        )
    }

    @Test
    fun associateWith() {
        assertOperationEquals(
            Iterable<String>::associateWith,
            NonEmptyCollection<String>::associateWith,
            { value -> value.length },
            "dffd", "324334", "3434", "Stefan", "234234"
        )
    }

    @Test
    fun associateBy() {
        assertOperationEquals(
            Iterable<String>::associateBy,
            NonEmptyCollection<String>::associateBy,
            { value -> value.length },
            "dffd", "324334", "3434", "Stefan", "234234"
        )
    }

    @Test
    fun mapValues() {
        assertMapOperationEquals(
            Map<String, Int>::mapValues,
            NonEmptyMap<String, Int>::mapValues,
            { entry -> entry.value * 2 },
            "dffd" to 10, "324334" to 455, "3434" to 69, "Stefan" to 9, "234234" to 0
        )
    }

    @Test
    fun mapKeys() {
        assertMapOperationEquals(
            Map<String, Int>::mapKeys,
            NonEmptyMap<String, Int>::mapKeys,
            { entry -> entry.value * 4 },
            "dffd" to 10, "324334" to 455, "3434" to 69, "Stefan" to 9, "234234" to 0
        )
    }

    @Test
    fun maxBy() {
        assertMapOperationEquals(
            Map<String, Int>::maxByOrNull,
            NonEmptyMap<String, Int>::maxBy,
            { entry -> entry.value * 14 },
            "dffd" to 10, "324334" to 455, "3434" to 69, "Stefan" to 9, "234234" to 0
        )
    }

    @Test
    fun map() {
        assertMapOperationEquals(
            Map<String, Int>::minByOrNull,
            NonEmptyMap<String, Int>::minBy,
            { entry -> entry.key },
            "dffd" to 10, "324334" to 455, "3434" to 69, "Stefan" to 9, "234234" to 0
        )
    }
}
