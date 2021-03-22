package com.quickbirdstudios.nonEmptyCollection.map

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection
import com.quickbirdstudios.nonEmptyCollection.set.NonEmptySet
import com.quickbirdstudios.nonEmptyCollection.unsafe.UnsafeNonEmptyCollectionApi
import com.quickbirdstudios.nonEmptyCollection.unsafe.toNonEmptyList
import com.quickbirdstudios.nonEmptyCollection.unsafe.toNonEmptySet

data class NonEmptyMap<K, V> internal constructor(
    internal val internalRepresentation: InternalRepresentation<K, V>
) : Map<K, V> by internalRepresentation.full {

    internal data class InternalRepresentation<K, V>(
        val first: Pair<K, V>,
        val rest: Map<K, V>
    ) {
        val full = mapOf(first) + rest
    }

    internal constructor(
        first: Pair<K, V>,
        rest: Map<K, V>
    ) : this(InternalRepresentation(first, rest))

    private val full
        get() = internalRepresentation.full

    internal val first
        get() = internalRepresentation.first

    internal val rest
        get() = internalRepresentation.rest

    @OptIn(UnsafeNonEmptyCollectionApi::class)
    override val entries: NonEmptySet<Map.Entry<K, V>>
        get() = full.entries.toNonEmptySet()

    @OptIn(UnsafeNonEmptyCollectionApi::class)
    override val keys: NonEmptySet<K>
        get() = full.keys.toNonEmptySet()

    @OptIn(UnsafeNonEmptyCollectionApi::class)
    override val values: NonEmptyCollection<V>
        get() = full.values.toNonEmptyList()

    override fun equals(other: Any?): Boolean = full == other

    override fun hashCode(): Int = full.hashCode()
}
