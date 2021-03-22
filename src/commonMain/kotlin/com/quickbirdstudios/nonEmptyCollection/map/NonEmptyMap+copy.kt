package com.quickbirdstudios.nonEmptyCollection.map

internal fun <K, V> NonEmptyMap<K, V>.copy(
    first: Pair<K, V> = internalRepresentation.first,
    rest: Map<K, V> = internalRepresentation.rest
) = copy(
    internalRepresentation = internalRepresentation.copy(
        first = first,
        rest = rest
    )
)
