@file:Suppress("unused")

package com.quickbirdstudios.nonEmptyCollection.map

fun <K, V> nonEmptyMapOf(
    entry: Pair<K, V>,
    vararg entries: Pair<K, V>
) = NonEmptyMap(
    first = entry,
    rest = mapOf(*entries)
)

fun <K, V> nonEmptyMapOf(
    entry: Pair<K, V>,
    entries: Map<K, V>
) = NonEmptyMap(
    first = entry,
    rest = entries
)
