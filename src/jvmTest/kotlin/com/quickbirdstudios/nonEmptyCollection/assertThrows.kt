package com.quickbirdstudios.nonEmptyCollection

import kotlin.test.assertTrue

inline fun <reified T : Throwable> assertThrows(action: () -> Unit) {
    var thrown = false
    try {
        action()
    } catch (caught: Throwable) {
        if (T::class.isInstance(caught)) {
            thrown = true
        }
    }

    assertTrue(thrown)
}
