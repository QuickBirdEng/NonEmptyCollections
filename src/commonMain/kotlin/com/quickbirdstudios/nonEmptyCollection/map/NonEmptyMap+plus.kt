package com.quickbirdstudios.nonEmptyCollection.map

operator fun <K, V> NonEmptyMap<K, V>.plus(entry: Pair<K, V>) = copy(rest = rest + entry)

operator fun <K, V> Map<K, V>.plus(entry: Pair<K, V>) = run {
    val first = entries.first()

    NonEmptyMap(
        first = first.key to first.value,
        rest = this + mapOf(entry) - first.key
    )
}

operator fun <K, V> NonEmptyMap<K, V>.plus(other: Map<K, V>) = copy(rest = rest + other)

operator fun <K, V> Map<K, V>.plus(
    other: NonEmptyMap<K, V>
): NonEmptyMap<K, V> = other + this

operator fun <K, V> NonEmptyMap<K, V>.plus(
    other: NonEmptyMap<K, V>
): NonEmptyMap<K, V> = this as Map<K, V> + other

operator fun <K, V> NonEmptyMap<K, V>.plus(
    other: Iterable<Pair<K, V>>
): NonEmptyMap<K, V> = this + other.toMap()

operator fun <K, V> NonEmptyMap<K, V>.plus(
    other: Sequence<Pair<K, V>>
): NonEmptyMap<K, V> = this + other.toMap()

operator fun <K, V> NonEmptyMap<K, V>.plus(
    other: Array<Pair<K, V>>
): NonEmptyMap<K, V> = this + other.toMap()
