package com.quickbirdstudios.nonEmptyCollection.list

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection

data class NonEmptyList<T> internal constructor(
    internal val head: T,
    internal val tail: List<T>
) : List<T> by listOf(head) as Collection<T> + tail, NonEmptyCollection<T> {

    override fun equals(other: Any?): Boolean = toList() == other

    override fun hashCode(): Int = toList().hashCode()
}
