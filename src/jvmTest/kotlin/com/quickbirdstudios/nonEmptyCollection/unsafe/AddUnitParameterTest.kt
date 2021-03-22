package com.quickbirdstudios.nonEmptyCollection.unsafe

import kotlin.test.Test
import kotlin.test.assertEquals

class AddUnitParameterTest {
    @Test
    fun zeroParameters() {
        val function = fun() = 69

        assertEquals(function(), function.addUnitParameter().invoke(Unit))
    }

    @Test
    fun oneParameter() {
        val function = fun(x: Int) = 69 * x

        assertEquals(function(42), function.addUnitParameter().invoke(42, Unit))
    }

    @Test
    fun twoParameters() {
        val function = fun(x: Int, y: Float) = 69 * x / y

        assertEquals(function(42, 420f), function.addUnitParameter().invoke(42, 420f, Unit))
    }
}
