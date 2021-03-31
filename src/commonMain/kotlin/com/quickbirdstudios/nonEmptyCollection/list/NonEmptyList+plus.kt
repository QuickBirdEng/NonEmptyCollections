package com.quickbirdstudios.nonEmptyCollection.list

import kotlin.collections.plus as stdPlus

operator fun <T> NonEmptyList<T>.plus(value: T): NonEmptyList<T> = full + value

operator fun <T> List<T>.plus(value: T): NonEmptyList<T> = NonEmptyList(this.stdPlus(value))

operator fun <T> NonEmptyList<T>.plus(
    other: Iterable<T>
): NonEmptyList<T> = NonEmptyList(full.stdPlus(other))

operator fun <T> List<T>.plus(
    other: NonEmptyList<T>
): NonEmptyList<T> = NonEmptyList(this.stdPlus(other.full))

operator fun <T> NonEmptyList<T>.plus(
    other: NonEmptyList<T>
): NonEmptyList<T> = full + other

operator fun <T> NonEmptyList<T>.plus(
    other: Sequence<T>
): NonEmptyList<T> = NonEmptyList(
    ArrayList<T>(full.size).apply {
        addAll(full)
        addAll(other)
    }
)

operator fun <T> NonEmptyList<T>.plus(
    other: Array<T>
): NonEmptyList<T> = NonEmptyList(
    ArrayList<T>(full.size + other.size).apply {
        addAll(full)
        addAll(other)
    }
)
