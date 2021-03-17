@file:Suppress("unused")

package com.quickbirdstudios.nonEmptyCollection.unsafe

inline fun <O> (() -> O).addUnitParameter() = { _: Unit -> this() }

inline fun <I, O> ((I) -> O).addUnitParameter() = { input: I, _: Unit -> this(input) }

inline fun <I1, I2, O> ((I1, I2) -> O).addUnitParameter() = { input1: I1, input2: I2, _: Unit ->
    this(input1, input2)
}
