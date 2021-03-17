@file:OptIn(UnsafeNonEmptyCollectionApi::class)
@file:Suppress("unused")

package com.quickbirdstudios.nonEmptyCollection.set

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection
import com.quickbirdstudios.nonEmptyCollection.unsafe.UnsafeNonEmptyCollectionApi
import com.quickbirdstudios.nonEmptyCollection.unsafe.toNonEmptySet
import com.quickbirdstudios.nonEmptyCollection.unsafe.wrapOperator

fun <T> NonEmptyCollection<T>.toNonEmptySet(): NonEmptySet<T> = toNonEmptySet()

fun <T> NonEmptySet<T>.onEach(
    action: (T) -> Unit
): NonEmptySet<T> = wrapOperator(action, Set<T>::onEach)

fun <T> NonEmptySet<T>.onEachIndexed(
    action: (index: Int, T) -> Unit
): NonEmptySet<T> = wrapOperator(action, Set<T>::onEachIndexed)

fun <T> NonEmptyCollection<T>.union(other: Iterable<T>): NonEmptySet<T> =
    wrapOperator(other, Iterable<T>::union)
