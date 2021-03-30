package com.quickbirdstudios.nonEmptyCollection.list

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection

class NonEmptyList<T> internal constructor(internal val full: List<T>) : List<T> by full, NonEmptyCollection<T> {
    constructor(
        head: T,
        tail: List<T>
    ) : this(ArrayList<T>(tail.size + 1).apply { add(head); addAll(tail) })

    init {
        require(full.isNotEmpty()) { "Fatal Error! This is a bug. Please contact the library author." }
    }

    override fun toString(): String = full.toString()

    override fun equals(other: Any?): Boolean = full == other

    override fun hashCode(): Int = full.hashCode()
}
