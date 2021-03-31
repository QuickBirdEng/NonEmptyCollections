package com.quickbirdstudios.nonEmptyCollection.map

import kotlin.collections.plus as stdPlus

operator fun <K, V> NonEmptyMap<K, V>.plus(entry: Pair<K, V>): NonEmptyMap<K, V> = full + entry

operator fun <K, V> Map<K, V>.plus(entry: Pair<K, V>): NonEmptyMap<K, V> = NonEmptyMap(this.stdPlus(entry))

operator fun <K, V> NonEmptyMap<K, V>.plus(other: Map<K, V>): NonEmptyMap<K, V> = NonEmptyMap(full.stdPlus(other))

operator fun <K, V> Map<K, V>.plus(
    other: NonEmptyMap<K, V>
): NonEmptyMap<K, V> = NonEmptyMap(this.stdPlus(other.full))

operator fun <K, V> NonEmptyMap<K, V>.plus(
    other: NonEmptyMap<K, V>
): NonEmptyMap<K, V> = full + other

operator fun <K, V> NonEmptyMap<K, V>.plus(
    other: Iterable<Pair<K, V>>
): NonEmptyMap<K, V> = NonEmptyMap(full.stdPlus(other))

operator fun <K, V> NonEmptyMap<K, V>.plus(
    other: Sequence<Pair<K, V>>
): NonEmptyMap<K, V> = NonEmptyMap(full.stdPlus(other))

operator fun <K, V> NonEmptyMap<K, V>.plus(
    other: Array<Pair<K, V>>
): NonEmptyMap<K, V> = NonEmptyMap(full.stdPlus(other))
