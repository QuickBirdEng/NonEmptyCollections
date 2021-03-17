package com.quickbirdstudios.nonEmptyCollection.map

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection
import com.quickbirdstudios.nonEmptyCollection.set.NonEmptySet
import com.quickbirdstudios.nonEmptyCollection.unsafe.UnsafeNonEmptyCollectionApi
import com.quickbirdstudios.nonEmptyCollection.unsafe.toNonEmptyList
import com.quickbirdstudios.nonEmptyCollection.unsafe.toNonEmptySet

data class NonEmptyMap<K, V> internal constructor(
    internal val first: Pair<K, V>,
    internal val rest: Map<K, V>
) : Map<K, V> by mapOf(first) + rest {

    private val map by lazy {
        mapOf(first) + rest
    }

    @OptIn(UnsafeNonEmptyCollectionApi::class)
    override val entries: NonEmptySet<Map.Entry<K, V>>
        get() = map.entries.toNonEmptySet()

    @OptIn(UnsafeNonEmptyCollectionApi::class)
    override val keys: NonEmptySet<K>
        get() = map.keys.toNonEmptySet()

    @OptIn(UnsafeNonEmptyCollectionApi::class)
    override val values: NonEmptyCollection<V>
        get() = map.values.toNonEmptyList()

    override fun equals(other: Any?): Boolean = toMap() == other

    override fun hashCode(): Int = toMap().hashCode()

}
