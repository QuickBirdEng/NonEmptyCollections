@file:OptIn(UnsafeNonEmptyCollectionApi::class)
@file:Suppress("unused")

package com.quickbirdstudios.nonEmptyCollection

import com.quickbirdstudios.nonEmptyCollection.list.NonEmptyList
import com.quickbirdstudios.nonEmptyCollection.map.NonEmptyMap
import com.quickbirdstudios.nonEmptyCollection.set.NonEmptySet
import com.quickbirdstudios.nonEmptyCollection.unsafe.UnsafeNonEmptyCollectionApi
import com.quickbirdstudios.nonEmptyCollection.unsafe.toNonEmptyList
import com.quickbirdstudios.nonEmptyCollection.unsafe.toNonEmptyMap
import com.quickbirdstudios.nonEmptyCollection.unsafe.toNonEmptySet

fun <T> List<T>.nonEmptyOr(
    alternative: List<T>.() -> NonEmptyList<T>
) = if (isEmpty()) alternative() else toNonEmptyList()

fun <T> Set<T>.nonEmptyOr(
    alternative: Set<T>.() -> NonEmptySet<T>
) = if (isEmpty()) alternative() else toNonEmptySet()

fun <K, V> Map<K, V>.nonEmptyOr(
    alternative: Map<K, V>.() -> NonEmptyMap<K, V>
) = if (isEmpty()) alternative() else toNonEmptyMap()

