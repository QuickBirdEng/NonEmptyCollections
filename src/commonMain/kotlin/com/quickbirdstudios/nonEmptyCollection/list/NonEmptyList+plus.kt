package com.quickbirdstudios.nonEmptyCollection.list

operator fun <T> NonEmptyList<T>.plus(value: T) = copy(tail = tail + value)

operator fun <T> List<T>.plus(value: T) = NonEmptyList(
    head = firstOrNull() ?: value,
    tail = (this + nonEmptyListOf(value)).drop(1)
)

operator fun <T> NonEmptyList<T>.plus(other: List<T>) = copy(
    tail = tail as Collection<T> + other
)

operator fun <T> List<T>.plus(
    other: NonEmptyList<T>
): NonEmptyList<T> = other.copy(
    head = this.firstOrNull() ?: other.head,
    tail = (this as Collection<T> + other).drop(1)
)

operator fun <T> NonEmptyList<T>.plus(
    other: NonEmptyList<T>
): NonEmptyList<T> = copy(tail = tail + other)

operator fun <T> NonEmptyList<T>.plus(
    other: Iterable<T>
): NonEmptyList<T> = this + other.toList()

operator fun <T> NonEmptyList<T>.plus(
    other: Sequence<T>
): NonEmptyList<T> = this + other.toList()

operator fun <T> NonEmptyList<T>.plus(
    other: Array<T>
): NonEmptyList<T> = this + other.toList()
