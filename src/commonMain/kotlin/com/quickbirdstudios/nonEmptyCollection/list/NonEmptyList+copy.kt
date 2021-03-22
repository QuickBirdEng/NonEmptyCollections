package com.quickbirdstudios.nonEmptyCollection.list

internal fun <T> NonEmptyList<T>.copy(
    head: T = internalRepresentation.head,
    tail: List<T> = internalRepresentation.tail
) = copy(
    internalRepresentation = internalRepresentation.copy(
        head = head,
        tail = tail
    )
)
