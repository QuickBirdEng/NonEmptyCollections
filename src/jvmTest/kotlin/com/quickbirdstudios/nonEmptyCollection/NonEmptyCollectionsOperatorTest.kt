package com.quickbirdstudios.nonEmptyCollection

import kotlin.test.Test

class NonEmptyCollectionsOperatorTest {

    @Test
    fun min() {
        assertOperationEquals(
            Iterable<Float>::minOrNull,
            NonEmptyCollection<Float>::min,
            0f, 12f, 430f, 6969f, -8978f
        )

        assertOperationEquals(
            Iterable<Double>::minOrNull,
            NonEmptyCollection<Double>::min,
            0.9, 123.9, 12.3, 69.89, -56.8, -57.9
        )

        assertOperationEquals(
            Iterable<String>::minOrNull,
            NonEmptyCollection<String>::min,
            "Stefan", "Klaus", "Mischa", "Malte", "Nasir", "Frederik"
        )
    }

    @Test
    fun max() {
        assertOperationEquals(
            Iterable<Float>::maxOrNull,
            NonEmptyCollection<Float>::max,
            0f, 12f, 430f, 6969f, -8978f
        )

        assertOperationEquals(
            Iterable<Double>::maxOrNull,
            NonEmptyCollection<Double>::max,
            0.9, 123.9, 12.3, 69.89, -56.8, -57.9
        )

        assertOperationEquals(
            Iterable<String>::maxOrNull,
            NonEmptyCollection<String>::max,
            "Stefan", "Klaus", "Mischa", "Malte", "Nasir", "Frederik"
        )
    }

    @Test
    fun minBy() {
        assertOperationEquals(
            Iterable<Float>::minByOrNull,
            NonEmptyCollection<Float>::minBy,
            { value -> -value * 2 },
            0f, 12f, 430f, 6969f, -8978f
        )

        assertOperationEquals(
            Iterable<Double>::minByOrNull,
            NonEmptyCollection<Double>::minBy,
            { value -> -value * 42.69 },
            0.9, 123.9, 12.3, 69.89, -56.8, -57.9
        )

        assertOperationEquals(
            Iterable<String>::minByOrNull,
            NonEmptyCollection<String>::minBy,
            { value -> value.length },
            "Stefan", "Klaus", "Mischa", "Malte", "Nasir", "Frederik"
        )
    }

    @Test
    fun maxBy() {
        assertOperationEquals(
            Iterable<Float>::maxByOrNull,
            NonEmptyCollection<Float>::maxBy,
            { value -> -value * 2 },
            0f, 12f, 430f, 6969f, -8978f
        )

        assertOperationEquals(
            Iterable<Double>::maxByOrNull,
            NonEmptyCollection<Double>::maxBy,
            { value -> -value * 42.69 },
            0.9, 123.9, 12.3, 69.89, -56.8, -57.9
        )

        assertOperationEquals(
            Iterable<String>::maxByOrNull,
            NonEmptyCollection<String>::maxBy,
            { value -> value.length },
            "Stefan", "Klaus", "Mischa", "Malte", "Nasir", "Frederik"
        )
    }
}
