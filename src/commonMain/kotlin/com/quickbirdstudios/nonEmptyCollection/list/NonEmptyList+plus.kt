package com.quickbirdstudios.nonEmptyCollection.list

operator fun <T> NonEmptyList<T>.plus(value: T): NonEmptyList<T> = NonEmptyList(full + value)

operator fun <T> List<T>.plus(value: T): NonEmptyList<T> = NonEmptyList(this as Collection<T> + value)

operator fun <T> NonEmptyList<T>.plus(other: List<T>): NonEmptyList<T> = NonEmptyList(full as Collection<T> + other)

operator fun <T> List<T>.plus(
    other: NonEmptyList<T>
): NonEmptyList<T> = NonEmptyList(this as Collection<T> + other.full)

operator fun <T> NonEmptyList<T>.plus(
    other: NonEmptyList<T>
): NonEmptyList<T> = NonEmptyList(full as Collection<T> + other.full)

operator fun <T> NonEmptyList<T>.plus(
    other: Iterable<T>
): NonEmptyList<T> = this + other.toList()

operator fun <T> NonEmptyList<T>.plus(
    other: Sequence<T>
): NonEmptyList<T> = this + other.toList()

operator fun <T> NonEmptyList<T>.plus(
    other: Array<T>
): NonEmptyList<T> = this + other.toList()
