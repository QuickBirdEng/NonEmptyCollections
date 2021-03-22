package com.quickbirdstudios.nonEmptyCollection.set

internal fun <T> NonEmptySet<T>.copy(
    first: T = internalRepresentation.first,
    rest: Set<T> = internalRepresentation.rest
) = copy(
    internalRepresentation = internalRepresentation.copy(
        first = first,
        rest = rest
    )
)
