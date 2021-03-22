package com.quickbirdstudios.nonEmptyCollection.map

import com.quickbirdstudios.nonEmptyCollection.assertOperationEquals

fun <K, V, R> assertMapOperationEquals(
    expected: Map<K, V>.() -> R,
    actual: NonEmptyMap<K, V>.() -> R,
    element: Pair<K, V>,
    vararg elements: Pair<K, V>
) = assertOperationEquals(
    expected = { toMap().expected() },
    actual = { toNonEmptyMap().actual() },
    element = element,
    elements = elements
)

fun <K, V, P, R> assertMapOperationEquals(
    expected: Map<K, V>.(P) -> R,
    actual: NonEmptyMap<K, V>.(P) -> R,
    parameter: P,
    element: Pair<K, V>,
    vararg elements: Pair<K, V>
) = assertOperationEquals(
    expected = { p -> toMap().expected(p) },
    actual = { p -> toNonEmptyMap().actual(p) },
    parameter = parameter,
    element = element,
    elements = elements
)

fun <K, V, P1, P2, R> assertMapOperationEquals(
    expected: Map<K, V>.(P1, P2) -> R,
    actual: NonEmptyMap<K, V>.(P1, P2) -> R,
    parameter1: P1,
    parameter2: P2,
    element: Pair<K, V>,
    vararg elements: Pair<K, V>
) = assertOperationEquals(
    expected = { p1, p2 -> toMap().expected(p1, p2) },
    actual = { p1, p2 -> toNonEmptyMap().actual(p1, p2) },
    parameter1 = parameter1,
    parameter2 = parameter2,
    element = element,
    elements = elements
)
