@file:Suppress("unused")

package com.quickbirdstudios.nonEmptyCollection.set

fun <T> nonEmptySetOf(value: T, vararg values: T) = nonEmptySetOf(value, values.toSet())

fun <T> nonEmptySetOf(value: T, values: Set<T>): NonEmptySet<T> = NonEmptySet(value, values)

fun <T : Any> nonEmptySetOfNotNull(
    value: T,
    vararg values: T?
) = nonEmptySetOfNotNull(value, setOf(*values))

fun <T : Any> nonEmptySetOfNotNull(
    value: T,
    values: Set<T?>
) = NonEmptySet(value, values.filterNotNull().toSet())
