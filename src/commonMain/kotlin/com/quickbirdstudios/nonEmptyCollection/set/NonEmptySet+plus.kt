package com.quickbirdstudios.nonEmptyCollection.set

import kotlin.collections.plus as stdPlus

operator fun <T> NonEmptySet<T>.plus(value: T): NonEmptySet<T> = full + value

operator fun <T> Set<T>.plus(value: T): NonEmptySet<T> = NonEmptySet(this.stdPlus(value))

operator fun <T> NonEmptySet<T>.plus(other: Set<T>) = NonEmptySet(full.stdPlus(other))

operator fun <T> Set<T>.plus(
    other: NonEmptySet<T>
): NonEmptySet<T> = NonEmptySet(this.stdPlus(other.full))

operator fun <T> NonEmptySet<T>.plus(
    other: NonEmptySet<T>
): NonEmptySet<T> = this + other.full

operator fun <T> NonEmptySet<T>.plus(
    other: Iterable<T>
): NonEmptySet<T> = NonEmptySet(full.stdPlus(other))

operator fun <T> NonEmptySet<T>.plus(
    other: Sequence<T>
): NonEmptySet<T> = NonEmptySet(full.stdPlus(other))

operator fun <T> NonEmptySet<T>.plus(
    other: Array<T>
): NonEmptySet<T> = NonEmptySet(full.stdPlus(other))
