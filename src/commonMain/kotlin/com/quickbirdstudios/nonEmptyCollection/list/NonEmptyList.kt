package com.quickbirdstudios.nonEmptyCollection.list

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection

data class NonEmptyList<T> internal constructor(
    internal val internalRepresentation: InternalRepresentation<T>
) : List<T> by internalRepresentation.full, NonEmptyCollection<T> {

    internal constructor(
        head: T,
        tail: List<T>
    ) : this(InternalRepresentation(head, tail))

    private val full
        get() = internalRepresentation.full

    internal val head
        get() = internalRepresentation.head

    internal val tail
        get() = internalRepresentation.tail

    internal data class InternalRepresentation<T>(
        val head: T,
        val tail: List<T>
    ) {
        val full = listOf(head) as Collection<T> + tail
        val set by lazy { full.toSet() }
    }

    override fun equals(other: Any?): Boolean = full == other

    override fun hashCode(): Int = full.hashCode()
}
