package com.quickbirdstudios.nonEmptyCollection.unsafe

import com.quickbirdstudios.nonEmptyCollection.list.NonEmptyList
import com.quickbirdstudios.nonEmptyCollection.list.nonEmptyListOf
import com.quickbirdstudios.nonEmptyCollection.map.NonEmptyMap
import com.quickbirdstudios.nonEmptyCollection.map.nonEmptyMapOf
import com.quickbirdstudios.nonEmptyCollection.set.NonEmptySet
import com.quickbirdstudios.nonEmptyCollection.set.nonEmptySetOf

@UnsafeNonEmptyCollectionApi
fun <T> Iterable<T>.toNonEmptyList(): NonEmptyList<T> = isAlreadyNonEmptyOr {
    NonEmptyList(toList())
}

@UnsafeNonEmptyCollectionApi
fun <T> Iterable<T>.toNonEmptySet(): NonEmptySet<T> = isAlreadyNonEmptyOr {
    toSet().toNonEmptySet()
}

@UnsafeNonEmptyCollectionApi
fun <T> Set<T>.toNonEmptySet(): NonEmptySet<T> = isAlreadyNonEmptyOr {
    NonEmptySet(this)
}

@UnsafeNonEmptyCollectionApi
fun <K, V> Iterable<Pair<K, V>>.toNonEmptyMap(): NonEmptyMap<K, V> = isAlreadyNonEmptyOr {
    toMap().toNonEmptyMap()
}

@UnsafeNonEmptyCollectionApi
fun <K, V> Map<K, V>.toNonEmptyMap(): NonEmptyMap<K, V> = isAlreadyNonEmptyOr {
    NonEmptyMap(this)
}

private inline fun <Empty, reified NonEmpty> Empty.isAlreadyNonEmptyOr(
    transform: Empty.() -> NonEmpty
) = if (this is NonEmpty) this else transform(this)
