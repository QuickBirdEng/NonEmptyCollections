package com.quickbirdstudios.nonEmptyCollection.set

import com.quickbirdstudios.nonEmptyCollection.assertOperationEquals

fun <T, R> assertSetOperationEquals(
    expected: Set<T>.() -> R,
    actual: NonEmptySet<T>.() -> R,
    element: T,
    vararg elements: T
) = assertOperationEquals(
    expected = { toSet().expected() },
    actual = { toNonEmptySet().actual() },
    element = element,
    elements = elements
)

fun <T, P, R> assertSetOperationEquals(
    expected: Set<T>.(P) -> R,
    actual: NonEmptySet<T>.(P) -> R,
    parameter: P,
    element: T,
    vararg elements: T
) = assertOperationEquals(
    expected = { p -> toSet().expected(p) },
    actual = { p -> toNonEmptySet().actual(p) },
    parameter = parameter,
    element = element,
    elements = elements
)

fun <T, P1, P2, R> assertSetOperationEquals(
    expected: Set<T>.(P1, P2) -> R,
    actual: NonEmptySet<T>.(P1, P2) -> R,
    parameter1: P1,
    parameter2: P2,
    element: T,
    vararg elements: T
) = assertOperationEquals(
    expected = { p1, p2 -> toSet().expected(p1, p2) },
    actual = { p1, p2 -> toNonEmptySet().actual(p1, p2) },
    parameter1 = parameter1,
    parameter2 = parameter2,
    element = element,
    elements = elements
)
