package com.quickbirdstudios.nonEmptyCollection.list

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection
import com.quickbirdstudios.nonEmptyCollection.assertOperationEquals
import com.quickbirdstudios.nonEmptyCollection.shuffled
import com.quickbirdstudios.nonEmptyCollection.unsafe.UnsafeNonEmptyCollectionApi
import com.quickbirdstudios.nonEmptyCollection.unsafe.toNonEmptyList
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class NonEmptyListOperatorsTest {
    @OptIn(UnsafeNonEmptyCollectionApi::class)
    @Test
    fun toNonEmptyList() {
        assertOperationEquals(
            Iterable<Int>::toNonEmptyList,
            NonEmptyCollection<Int>::toNonEmptyList,
            23, 324334, -3434
        )
    }

    @Test
    fun asReversed() {
        assertListOperationEquals(
            List<Int>::asReversed,
            NonEmptyList<Int>::asReversed,
            23, 324334, -3434
        )
    }

    @Test
    fun sorted() {
        assertOperationEquals(
            Iterable<Int>::sorted,
            NonEmptyCollection<Int>::sorted,
            23, 324334, -3434, 7878, 234234
        )
    }

    @Test
    fun sortedBy() {
        assertOperationEquals(
            Iterable<Int>::sortedBy,
            NonEmptyCollection<Int>::sortedBy,
            { value -> value.toDouble() * 42 - 5 },
            23, 324334, -3434, 7878, 234234
        )
    }

    @Test
    fun sortedWith() {
        assertOperationEquals(
            Iterable<String>::sortedWith,
            NonEmptyCollection<String>::sortedWith,
            object : Comparator<String> {
                override fun compare(first: String?, second: String?): Int {
                    if (first == null || second == null) return 0
                    return first.length.compareTo(second.length)
                }

            },
            "d", "32", "3434", "Stefan", "2342344"
        )
    }

    @Test
    fun sortedDescending() {
        assertOperationEquals(
            Iterable<String>::sortedDescending,
            NonEmptyCollection<String>::sortedDescending,
            "dffd", "324334", "3434", "Stefan", "234234"
        )
    }

    @Test
    fun sortedByDescending() {
        assertOperationEquals(
            Iterable<Int>::sortedByDescending,
            NonEmptyCollection<Int>::sortedByDescending,
            { value -> value.toDouble() * 42 - 5 },
            23, 324334, -3434, 7878, 234234
        )
    }

    @Test
    fun onEach() {
        val mutableList = mutableListOf<Unit>()

        assertListOperationEquals(
            List<String>::onEach,
            NonEmptyList<String>::onEach,
            { mutableList.add(Unit) },
            "dffd", "324334", "3434", "Stefan", "234234"
        )
        assertEquals(10, mutableList.size)
    }

    @Test
    fun onEachIndexed() {
        val mutableList = mutableListOf<Int>()

        assertListOperationEquals(
            List<String>::onEachIndexed,
            NonEmptyList<String>::onEachIndexed,
            { index, _ -> mutableList.add(index) },
            "dffd", "324334", "3434", "Stefan", "234234"
        )
        assertEquals(10, mutableList.size)
        assertEquals(5, mutableList.distinct().size)
    }

    @Test
    fun map() {
        assertOperationEquals(
            Iterable<String>::map,
            NonEmptyCollection<String>::map,
            { value -> value + value },
            "dffd", "324334", "3434", "Stefan", "234234"
        )
    }

    @Test
    fun mapIndexed() {
        assertOperationEquals(
            Iterable<String>::mapIndexed,
            NonEmptyCollection<String>::mapIndexed,
            { index, value -> value + index },
            "dffd", "324334", "3434", "Stefan", "234234"
        )
    }

    @Test
    fun flatMap() {
        assertOperationEquals(
            Iterable<String>::flatMap,
            NonEmptyCollection<String>::flatMap,
            { value -> nonEmptyListOf(value, value) },
            "dffd", "324334", "3434", "Stefan", "234234"
        )
    }

    @Test
    fun flatMapIndexed() {
        assertOperationEquals(
            Iterable<String>::flatMapIndexed,
            NonEmptyCollection<String>::flatMapIndexed,
            { index, _ -> nonEmptyListOf(index * 2) },
            "dffd", "324334", "3434", "Stefan", "234234"
        )
    }

    @Test
    fun scan() {
        assertOperationEquals(
            Iterable<String>::scan,
            NonEmptyCollection<String>::scan,
            "",
            { acc, value -> acc + value + value },
            "dffd", "324334", "3434", "Stefan", "234234"
        )
    }

    @Test
    fun scanIndexed() {
        assertOperationEquals(
            Iterable<String>::scanIndexed,
            NonEmptyCollection<String>::scanIndexed,
            "",
            { index, acc, value -> acc + value + value + index },
            "dffd", "324334", "3434", "Stefan", "234234"
        )
    }

    @Test
    fun runningReduce() {
        assertOperationEquals(
            Iterable<Double>::runningReduce,
            NonEmptyCollection<Double>::runningReduce,
            { acc, value -> acc + value + value },
            -22.0, 420.0, 69.0, 69.69, 69.0
        )
    }

    @Test
    fun runningReduceIndexed() {
        assertOperationEquals(
            Iterable<Double>::runningReduceIndexed,
            NonEmptyCollection<Double>::runningReduceIndexed,
            { index, acc, value -> acc + value + value + index },
            -22.0, 420.0, 69.0, 69.69, 69.0
        )
    }

    @Test
    fun runningFold() {
        assertOperationEquals(
            Iterable<Double>::runningFold,
            NonEmptyCollection<Double>::runningFold,
            32.0,
            { acc, value -> acc + value + value },
            -22.0, 420.0, 69.0, 69.69, 69.0
        )
    }

    @Test
    fun runningFoldIndexed() {
        assertOperationEquals(
            Iterable<Double>::runningFoldIndexed,
            NonEmptyCollection<Double>::runningFoldIndexed,
            32.0,
            { index, acc, value -> acc + value + value + index },
            -22.0, 420.0, 69.0, 69.69, 69.0
        )
    }

    @Test
    fun flatten() {
        assertOperationEquals(
            Iterable<Iterable<Double>>::flatten,
            NonEmptyCollection<NonEmptyCollection<Double>>::flatten,
            nonEmptyListOf(-22.0, 420.0, 69.0), nonEmptyListOf(69.69, 69.0)
        )
    }

    @Test
    fun reversed() {
        assertOperationEquals(
            Iterable<Iterable<Double>>::reversed,
            NonEmptyCollection<NonEmptyCollection<Double>>::reversed,
            nonEmptyListOf(-22.0, 420.0, 69.0), nonEmptyListOf(69.69, 69.0)
        )
    }

    @Test
    fun zip() {
        assertOperationEquals(
            Iterable<Double>::zip,
            NonEmptyCollection<Double>::zip,
            nonEmptyListOf(-22.0, 420.0, 69.0),
            69.69, 69.0
        )
    }

    @Test
    fun chunked() {
        assertOperationEquals(
            Iterable<Double>::chunked,
            NonEmptyCollection<Double>::chunked,
            2,
            -22.0, 420.0, 69.0, 69.69, 69.0
        )
    }

    @Test
    fun chunked_withTransformation() {
        assertOperationEquals(
            expected = Iterable<Double>::chunked,
            actual = NonEmptyCollection<Double>::chunked,
            parameter1 = 2,
            parameter2 = { list: List<Double> -> list.size },
            -22.0, 420.0, 69.0, 69.69, 69.0
        )
    }

    @Test
    fun withIndex() {
        val withIndexToList = fun Iterable<Double>.() = withIndex().toList()

        assertListOperationEquals(
            withIndexToList,
            NonEmptyList<Double>::withIndex,
            -22.0, 420.0, 69.0, 69.69, 69.0
        )
    }
}
