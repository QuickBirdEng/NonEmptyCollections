package com.quickbirdstudios.nonEmptyCollection

import com.quickbirdstudios.nonEmptyCollection.list.nonEmptyListOf
import com.quickbirdstudios.nonEmptyCollection.map.nonEmptyMapOf
import com.quickbirdstudios.nonEmptyCollection.set.nonEmptySetOf
import kotlin.test.Test
import kotlin.test.assertEquals

class NonEmptyOrTest {
    @Test
    fun nonEmptyOr_alternative() {
        val alternativeList = nonEmptyListOf(1, 2, 4)
        val list = listOf<Int>()

        val alternativeSet = nonEmptySetOf(1, 2, 4)
        val set = setOf<Int>()

        val alternativeMap = nonEmptyMapOf(1 to "3", 2 to "rrr", 4 to "sfgfdgdf")
        val map = mapOf<Int, String>()

        assertEquals(alternativeList, list.nonEmptyOr { alternativeList })
        assertEquals(alternativeSet, set.nonEmptyOr { alternativeSet })
        assertEquals(alternativeMap, map.nonEmptyOr { alternativeMap })
    }

    @Test
    fun nonEmptyOr_notAlternative() {
        val alternativeList = nonEmptyListOf(1, 2, 4)
        val list = listOf(45, 54, 666)

        val alternativeSet = nonEmptySetOf(1, 2, 4)
        val set = setOf(-5656, 555, 4949, 99)

        val alternativeMap = nonEmptyMapOf(1 to "3", 2 to "rrr", 4 to "sfgfdgdf")
        val map = mapOf(69 to "420")

        assertEquals(list, list.nonEmptyOr { alternativeList })
        assertEquals(set, set.nonEmptyOr { alternativeSet })
        assertEquals(map, map.nonEmptyOr { alternativeMap })
    }
}
