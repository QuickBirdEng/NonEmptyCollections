@file:Suppress("unused")

package com.quickbirdstudios.nonEmptyCollection.list

fun <T> nonEmptyListOf(value: T, vararg values: T) = nonEmptyListOf(value, values.asList())

fun <T> nonEmptyListOf(value: T, values: List<T>) = NonEmptyList(value, values)

fun <T : Any> nonEmptyListOfNotNull(
    value: T,
    vararg values: T?
) = nonEmptyListOfNotNull(value, values.asList())

fun <T : Any> nonEmptyListOfNotNull(
    value: T,
    values: List<T?>
) = NonEmptyList(value, values.filterNotNull())
