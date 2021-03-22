package com.quickbirdstudios.nonEmptyCollection

import com.quickbirdstudios.nonEmptyCollection.list.nonEmptyListOf
import com.quickbirdstudios.nonEmptyCollection.unsafe.addUnitParameter
import kotlin.test.assertEquals

fun <T, R> assertOperationEquals(
    expected: Iterable<T>.() -> R,
    actual: NonEmptyCollection<T>.() -> R,
    element: T,
    vararg elements: T
) = assertOperationEquals(
    expected = expected.addUnitParameter(),
    actual = actual.addUnitParameter(),
    parameter = Unit,
    element = element,
    elements = elements
)

fun <T, P, R> assertOperationEquals(
    expected: Iterable<T>.(P) -> R,
    actual: NonEmptyCollection<T>.(P) -> R,
    parameter: P,
    element: T,
    vararg elements: T
) = assertOperationEquals(
    expected = expected.addUnitParameter(),
    actual = actual.addUnitParameter(),
    parameter1 = parameter,
    parameter2 = Unit,
    element = element,
    elements = elements
)

fun <T, P1, P2, R> assertOperationEquals(
    expected: Iterable<T>.(P1, P2) -> R,
    actual: NonEmptyCollection<T>.(P1, P2) -> R,
    parameter1: P1,
    parameter2: P2,
    element: T,
    vararg elements: T
) {
    val list = listOf(element, *elements)
    val nonEmptyList = nonEmptyListOf(element, *elements)

    assertEquals(list.expected(parameter1, parameter2), nonEmptyList.actual(parameter1, parameter2))
}
