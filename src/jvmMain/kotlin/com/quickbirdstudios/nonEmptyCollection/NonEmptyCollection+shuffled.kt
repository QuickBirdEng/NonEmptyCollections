@file:OptIn(UnsafeNonEmptyCollectionApi::class)
@file:Suppress("unused")

package com.quickbirdstudios.nonEmptyCollection

import com.quickbirdstudios.nonEmptyCollection.unsafe.UnsafeNonEmptyCollectionApi
import com.quickbirdstudios.nonEmptyCollection.unsafe.wrapOperator
import java.util.*

fun <T> NonEmptyCollection<T>.shuffled() = wrapOperator(Iterable<T>::shuffled)

fun <T> NonEmptyCollection<T>.shuffled(random: Random) = wrapOperator(random, Iterable<T>::shuffled)
