@file:OptIn(UnsafeNonEmptyCollectionApi::class)
@file:Suppress("unused")

package com.quickbirdstudios.nonEmptyCollection.map

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection
import com.quickbirdstudios.nonEmptyCollection.list.NonEmptyList
import com.quickbirdstudios.nonEmptyCollection.unsafe.UnsafeNonEmptyCollectionApi
import com.quickbirdstudios.nonEmptyCollection.unsafe.toNonEmptyMap
import com.quickbirdstudios.nonEmptyCollection.unsafe.wrapOperator

fun <K, V> NonEmptyCollection<Pair<K, V>>.toNonEmptyMap(): NonEmptyMap<K, V> = toNonEmptyMap()

fun <K, V> NonEmptyMap<K, V>.onEach(
    action: (Map.Entry<K, V>) -> Unit
): NonEmptyMap<K, V> = wrapOperator(action, Map<K, V>::onEach)

fun <K, V> NonEmptyMap<K, V>.onEachIndexed(
    action: (index: Int, Map.Entry<K, V>) -> Unit
): NonEmptyMap<K, V> = wrapOperator(action, Map<K, V>::onEachIndexed)

fun <T, K, V> NonEmptyCollection<T>.associate(
    transform: (T) -> Pair<K, V>
): NonEmptyMap<K, V> = wrapOperator(transform, Iterable<T>::associate)

fun <K, V> NonEmptyCollection<K>.associateWith(
    valueSelector: (K) -> V
): NonEmptyMap<K, V> = wrapOperator(valueSelector, Iterable<K>::associateWith)

fun <K, V> NonEmptyCollection<V>.associateBy(
    keySelector: (V) -> K
): NonEmptyMap<K, V> = wrapOperator(keySelector, Iterable<V>::associateBy)

fun <K, V, R> NonEmptyMap<K, V>.mapValues(
    transform: (Map.Entry<K, V>) -> R
): NonEmptyMap<K, R> = wrapOperator(transform, Map<K, V>::mapValues)

fun <K, V, R> NonEmptyMap<K, V>.mapKeys(
    transform: (Map.Entry<K, V>) -> R
): NonEmptyMap<R, V> = wrapOperator(transform, Map<K, V>::mapKeys)

fun <K, V, R> NonEmptyMap<K, V>.map(
    transform: (Map.Entry<K, V>) -> R
): NonEmptyList<R> = wrapOperator(transform, Map<K, V>::map)

fun <K, V, R : Comparable<R>> NonEmptyMap<K, V>.maxBy(
    selector: (Map.Entry<K, V>) -> R
): Map.Entry<K, V> = maxByOrNull(selector)!!

fun <K, V, R : Comparable<R>> NonEmptyMap<K, V>.minBy(
    selector: (Map.Entry<K, V>) -> R
): Map.Entry<K, V> = minByOrNull(selector)!!
