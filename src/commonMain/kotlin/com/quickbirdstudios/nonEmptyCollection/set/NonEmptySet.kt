package com.quickbirdstudios.nonEmptyCollection.set

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection

data class NonEmptySet<T> internal constructor(
    internal val internalRepresentation: InternalRepresentation<T>
) : Set<T> by internalRepresentation.full, NonEmptyCollection<T> {

    internal data class InternalRepresentation<T>(
        val first: T,
        val rest: Set<T>
    ) {
        val full = rest.plusElement(first)
        val list by lazy { full.toList() }
    }

    internal constructor(
        first: T,
        rest: Set<T>
    ) : this(InternalRepresentation(first, rest))

    private val full
        get() = internalRepresentation.full

    internal val first
        get() = internalRepresentation.first

    internal val rest
        get() = internalRepresentation.rest

    override fun equals(other: Any?): Boolean = full == other

    override fun hashCode(): Int = full.hashCode()
}
