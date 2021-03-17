@file:OptIn(UnsafeNonEmptyCollectionApi::class)
@file:Suppress("unused")

package com.quickbirdstudios.nonEmptyCollection.list

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection
import com.quickbirdstudios.nonEmptyCollection.unsafe.UnsafeNonEmptyCollectionApi
import com.quickbirdstudios.nonEmptyCollection.unsafe.toNonEmptyList
import com.quickbirdstudios.nonEmptyCollection.unsafe.wrapOperator

fun <T> NonEmptyCollection<T>.toNonEmptyList(): NonEmptyList<T> = toNonEmptyList()

fun <T> NonEmptyCollection<T>.asReversed(): NonEmptyList<T> = wrapOperator(List<T>::asReversed)

fun <T : Comparable<T>> NonEmptyCollection<T>.sorted() = wrapOperator(Iterable<T>::sorted)

fun <T, R : Comparable<R>> NonEmptyCollection<T>.sortedBy(
    selector: (T) -> R?
) = wrapOperator(selector, Iterable<T>::sortedBy)

fun <T> NonEmptyCollection<T>.sortedWith(
    comparator: Comparator<in T>
) = wrapOperator(comparator, Iterable<T>::sortedWith)

fun <T : Comparable<T>> NonEmptyCollection<T>.sortedDescending() =
    wrapOperator(Iterable<T>::sortedDescending)

fun <T, R : Comparable<R>> NonEmptyCollection<T>.sortedByDescending(
    selector: (T) -> R?
) = wrapOperator(selector, Iterable<T>::sortedByDescending)

fun <T> NonEmptyList<T>.onEach(
    action: (T) -> Unit
) = wrapOperator(action, List<T>::onEach)

fun <T> NonEmptyList<T>.onEachIndexed(
    action: (index: Int, T) -> Unit
) = wrapOperator(action, List<T>::onEachIndexed)

fun <T, R> NonEmptyCollection<T>.map(
    transform: (T) -> R
) = wrapOperator(transform, Iterable<T>::map)

fun <T, R> NonEmptyCollection<T>.mapIndexed(
    transform: (index: Int, T) -> R
) = wrapOperator(transform, Iterable<T>::mapIndexed)

fun <T, R> NonEmptyCollection<T>.flatMap(
    transform: (T) -> NonEmptyList<R>
): NonEmptyList<R> = wrapOperator(transform, Iterable<T>::flatMap)

fun <T, R> NonEmptyCollection<T>.flatMapIndexed(
    transform: (index: Int, T) -> NonEmptyList<R>
) = wrapOperator(transform, Iterable<T>::flatMapIndexed)

fun <T, R> NonEmptyCollection<T>.scan(
    initial: R,
    operation: (acc: R, T) -> R
) = wrapOperator(initial, operation, Iterable<T>::scan)

fun <T, R> NonEmptyCollection<T>.scanIndexed(
    initial: R,
    operation: (index: Int, acc: R, T) -> R
) = wrapOperator(initial, operation, Iterable<T>::scanIndexed)

fun <S, T : S> NonEmptyCollection<T>.runningReduce(
    operation: (acc: S, T) -> S
) = wrapOperator(operation, Iterable<T>::runningReduce)

fun <S, T : S> NonEmptyCollection<T>.runningReduceIndexed(
    operation: (index: Int, acc: S, T) -> S
) = wrapOperator(operation, Iterable<T>::runningReduceIndexed)

fun <T, R> NonEmptyCollection<T>.runningFold(
    initial: R,
    operation: (acc: R, T) -> R
) = wrapOperator(initial, operation, Iterable<T>::runningFold)

fun <T, R> NonEmptyCollection<T>.runningFoldIndexed(
    initial: R,
    operation: (index: Int, acc: R, T) -> R
) = wrapOperator(initial, operation, Iterable<T>::runningFoldIndexed)

fun <T> NonEmptyCollection<NonEmptyCollection<T>>.flatten() =
    wrapOperator(Iterable<Iterable<T>>::flatten)

fun <T> NonEmptyCollection<T>.reversed() = wrapOperator(Iterable<T>::reversed)

fun <T> NonEmptyCollection<T>.zip(other: NonEmptyCollection<T>) =
    wrapOperator(other, Iterable<T>::zip)

fun <T> NonEmptyCollection<T>.chunked(
    size: Int
): NonEmptyList<NonEmptyList<T>> = wrapOperator(size, Iterable<T>::chunked)
    .map { chunk -> chunk.toNonEmptyList() }

fun <T, R> NonEmptyCollection<T>.chunked(
    size: Int,
    transform: (List<T>) -> R
) = wrapOperator(size, transform, Iterable<T>::chunked)

fun <T> NonEmptyList<T>.withIndex(): NonEmptyList<IndexedValue<T>> {
    val operation = { iterable: Iterable<T> -> iterable.withIndex().toList() }
    return wrapOperator(operation)
}
