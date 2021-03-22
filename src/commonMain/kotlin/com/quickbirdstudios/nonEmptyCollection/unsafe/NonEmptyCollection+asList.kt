package com.quickbirdstudios.nonEmptyCollection.unsafe

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection
import com.quickbirdstudios.nonEmptyCollection.list.NonEmptyList
import com.quickbirdstudios.nonEmptyCollection.set.NonEmptySet

@UnsafeNonEmptyCollectionApi
fun <T> NonEmptyCollection<T>.asList(): List<T> = when (this) {
    is NonEmptyList<T> -> internalRepresentation.full
    is NonEmptySet<T> -> internalRepresentation.list
    else -> throw NotImplementedError(
        "This function is not implemented for $this non-empty collection type"
    )
}
