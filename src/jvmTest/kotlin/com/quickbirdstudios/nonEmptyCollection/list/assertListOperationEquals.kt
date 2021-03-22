package com.quickbirdstudios.nonEmptyCollection.list

import com.quickbirdstudios.nonEmptyCollection.assertOperationEquals

fun <T, R> assertListOperationEquals(
    expected: List<T>.() -> R,
    actual: NonEmptyList<T>.() -> R,
    element: T,
    vararg elements: T
) = assertOperationEquals(
    expected = { toList().expected() },
    actual = { toNonEmptyList().actual() },
    element = element,
    elements = elements
)

fun <T, P, R> assertListOperationEquals(
    expected: List<T>.(P) -> R,
    actual: NonEmptyList<T>.(P) -> R,
    parameter: P,
    element: T,
    vararg elements: T
) = assertOperationEquals(
    expected = { p -> toList().expected(p) },
    actual = { p -> toNonEmptyList().actual(p) },
    parameter = parameter,
    element = element,
    elements = elements
)

fun <T, P1, P2, R> assertListOperationEquals(
    expected: List<T>.(P1, P2) -> R,
    actual: NonEmptyList<T>.(P1, P2) -> R,
    parameter1: P1,
    parameter2: P2,
    element: T,
    vararg elements: T
) = assertOperationEquals(
    expected = { p1, p2 -> toList().expected(p1, p2) },
    actual = { p1, p2 -> toNonEmptyList().actual(p1, p2) },
    parameter1 = parameter1,
    parameter2 = parameter2,
    element = element,
    elements = elements
)
