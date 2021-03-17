package com.quickbirdstudios.nonEmptyCollection.set

operator fun <T> NonEmptySet<T>.plus(value: T) = copy(rest = rest + value)

operator fun <T> Set<T>.plus(value: T) = run {
    val first = firstOrNull() ?: value

    NonEmptySet(
        first = first,
        rest = (this.plusElement(value)) - first
    )
}

operator fun <T> NonEmptySet<T>.plus(other: Set<T>) = copy(rest = rest union other)

operator fun <T> Set<T>.plus(
    other: NonEmptySet<T>
): NonEmptySet<T> = other + this

operator fun <T> NonEmptySet<T>.plus(
    other: NonEmptySet<T>
): NonEmptySet<T> = this as Set<T> + other

operator fun <T> NonEmptySet<T>.plus(
    other: Iterable<T>
): NonEmptySet<T> = this + other.toSet()

operator fun <T> NonEmptySet<T>.plus(
    other: Sequence<T>
): NonEmptySet<T> = this + other.toSet()

operator fun <T> NonEmptySet<T>.plus(
    other: Array<T>
): NonEmptySet<T> = this + other.toSet()
