package com.quickbirdstudios.nonEmptyCollection.map

class NonEmptyMap<K, out V> internal constructor(internal val full: Map<K, V>) : Map<K, V> by full {
    constructor(
        first: Pair<K, V>,
        rest: Map<K, V>
    ) : this(LinkedHashMap<K, V>(rest.size + 1).apply { put(first.first, first.second); putAll(rest) })

    init {
        require(full.isNotEmpty()) { "Fatal Error! This is a bug. Please contact the library author." }
    }

    override fun toString(): String = full.toString()

    override fun equals(other: Any?): Boolean = full == other

    override fun hashCode(): Int = full.hashCode()
}
