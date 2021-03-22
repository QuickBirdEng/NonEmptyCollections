package com.quickbirdstudios.nonEmptyCollection.unsafe

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection
import com.quickbirdstudios.nonEmptyCollection.list.NonEmptyList
import com.quickbirdstudios.nonEmptyCollection.set.NonEmptySet

@UnsafeNonEmptyCollectionApi
fun <T> NonEmptyCollection<T>.asSet(): Set<T> = when (this) {
    is NonEmptyList<T> -> internalRepresentation.full.toSet()
    is NonEmptySet<T> -> internalRepresentation.full
    else -> throw NotImplementedError(
        "This function is not implemented for $this non-empty collection type"
    )
}
