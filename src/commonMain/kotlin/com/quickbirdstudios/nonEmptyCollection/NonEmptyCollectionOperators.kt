@file:Suppress("unused")

package com.quickbirdstudios.nonEmptyCollection

fun <T : Comparable<T>> NonEmptyCollection<T>.max() = maxOrNull()!!

fun NonEmptyCollection<Float>.max() = maxOrNull()!!

fun NonEmptyCollection<Double>.max() = maxOrNull()!!

fun <T, R : Comparable<R>> NonEmptyCollection<T>.maxBy(selector: (T) -> R) = maxByOrNull(selector)!!

fun <T : Comparable<T>> NonEmptyCollection<T>.min() = minOrNull()!!

fun NonEmptyCollection<Float>.min() = minOrNull()!!

fun NonEmptyCollection<Double>.min() = minOrNull()!!

fun <T, R : Comparable<R>> NonEmptyCollection<T>.minBy(selector: (T) -> R) = minByOrNull(selector)!!
