package com.quickbirdstudios.nonEmptyCollection.set

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection

data class NonEmptySet<T> internal constructor(
    internal val first: T,
    internal val rest: Set<T>
) : Set<T> by rest.plusElement(first), NonEmptyCollection<T> {

    override fun equals(other: Any?): Boolean = toSet() == other

    override fun hashCode(): Int = toSet().hashCode()
}
