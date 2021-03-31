package com.quickbirdstudios.nonEmptyCollection.set

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection

class NonEmptySet<T> internal constructor(
    internal val full: Set<T>
) : Set<T> by full, NonEmptyCollection<T> {
    constructor(
        first: T,
        rest: Set<T>
    ) : this(HashSet<T>(rest.size + 1).apply { add(first); addAll(rest) })

    override fun toString(): String = full.toString()

    override fun equals(other: Any?): Boolean = full == other

    override fun hashCode(): Int = full.hashCode()
}
